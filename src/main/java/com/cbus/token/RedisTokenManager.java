package com.cbus.token;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.cbus.exception.TgException;
import com.cbus.po.param.TgAuth;
import com.cbus.utils.TgCode;
import com.s3.po.CodeData;
import com.s3.utils.JsonUtils;
import com.s3.utils.TGCode;
import com.s3.utils.ToolUtils;

/**
 * 身份信息管理类
 * @author zhen.lin
 * @date 2019年8月14日
 */
@Component
public class RedisTokenManager {

    /**
     * key的生命周期 默认7200秒
     */
    @Value("${app.session.timeout:1800}")
    private int appSessionTimeout;

    /**
     * 请求超时时间
     */
    private static int URL_REQUEST_TIMEOUT = 600;

    private static String TOKEN_BUS = "TOKEN:BUS";

    // Key类型操作
    // ValueOperations Redis String/Value 操作
    // ListOperations Redis List 操作
    // SetOperations Redis Set 操作
    // ZSetOperations Redis Sort Set 操作
    // HashOperations Redis Hash 操作
    // Value约束操作
    // BoundValueOperations Redis String/Value key 约束
    // BoundListOperations Redis List key 约束
    // BoundSetOperations Redis Set key 约束
    // BoundZSetOperations Redis Sort Set key 约束
    // BoundHashOperations Redis Hash key 约束

    // private HashOperations<String, String, TokenModel> listOps;
    
    
    @Resource(name = "redisStringTemplate")
    private ValueOperations<String, String> valOps;

    @Resource(name = "redisStringTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisStringTemplate")
    private HashOperations<String, String, String> serverlistOps;

    /**
     * 获取Token @param key @return @throws
     */
    public TokenModel getTokenModel(String key) {
        String data = valOps.get(key);
        if (data != null) {
            // 更新过期时间
            int time = this.appSessionTimeout;
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return JsonUtils.str2Obj(data, TokenModel.class);
        } else {
            return null;
        }
    }

    /**
     * 创建Token，一般在一个用户login时创建
     * 
     * @param hash
     * @param hk
     * @param value
     */
    public void setTokenModel(String key, TokenModel value) {
        int time = this.appSessionTimeout;

        valOps.set(key, JsonUtils.obj2Str(value), time, TimeUnit.SECONDS);
    }

    /**
     * 删除一个token
     * 
     * @param hash
     * @param hk
     */
    public void delTokenModel(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 返回tokey值
     * 
     * @param key
     * @return
     */
    public String getToken(String key) {
        TokenModel tm = getTokenModel(key);
        if (tm == null) {
            return null;
        } else {
            return tm.getToken();
        }
    }

    /**
     * 通过用户id获取token信息
     * 
     * @param gid
     * @return 失败返回 list<> 空列表 同一用户多次login时，会出现多笔记录
     */
    public List<TokenModel> getTokenModelByUid(String uid) {
        List<TokenModel> ret = new ArrayList<TokenModel>();
        if (uid == null || "".equals(uid)) {
            return ret;
        }
        Set<String> keyset = redisTemplate.keys(TOKEN_BUS + ":*");
        List<String> list = valOps.multiGet(keyset);
        for (int i = 0; i < list.size(); i++) {
            TokenModel tm = JsonUtils.str2Obj(list.get(i), TokenModel.class);
            if (uid.equalsIgnoreCase(tm.getUid())) {
                ret.add(tm);
            }
        }
        return ret;
    }

    /**
     * 加密 128位 @param content 需要加密的内容 @param skey 加密密码 不够16位 在后边补 0x00 @return @throws
     */
    public byte[] encodeAES(String content, String skey) {
        try {
            byte[] keybyte = Arrays.copyOf(skey.getBytes("utf-8"), 16);
            SecretKeySpec key = new SecretKeySpec(keybyte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // 使用CBC模式，需要一个向量iv，可增加加密算法的强度 ECB不需以下这行
            IvParameterSpec iv = new IvParameterSpec("0192939495969798".getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] result = cipher.doFinal(content.getBytes("utf-8"));
            return result;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密 128位
     * 
     * @param content
     *            待解密内容
     * @param skey
     *            解密密钥 不够16位 在后边补 0x00
     * @return
     */
    public byte[] decodeAES(byte[] content, String skey) {
        try {
            SecretKeySpec key = new SecretKeySpec(Arrays.copyOf(skey.getBytes("utf-8"), 16), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // CBC需要iv，ECB不需要
            IvParameterSpec iv = new IvParameterSpec("0192939495969798".getBytes());
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] result = cipher.doFinal(content);
            // 加密
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 编码token 规则 将token进行aes加密, 最后转为base64 AES/CBC/PKCS5Padding PKCS5Padding的补码方式，其实就是PKCS7 iv=0192939495969798
     * 
     * @return
     */
    public String encodeToken(String token, String skey) {
        String ret = token.toLowerCase();
        // 简单加密 把明文中的所有数字+1，大于9的=0
        StringBuilder str = new StringBuilder(ret);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 只处理数字类型
            if (Character.isDigit(c)) {
                int x = Integer.parseInt(String.valueOf(c));
                x++;
                // 大于9的，转为0
                if (x > 9) {
                    x = 0;
                }
                char ch1 = (char)(x + 48);
                str.setCharAt(i, ch1);
            }
        }
        ret = str.toString();
        byte[] src = this.encodeAES(ret, skey);
        return Base64.getEncoder().encodeToString(src);
    }

    /**
     * 计算url签名
     * 
     * @param uid
     * @param token
     * @param time
     * @return
     */
    public String signUrl(String uid, String token, String time) {
        String str = "time=" + time + "&token=" + token + "&uid=" + uid;
        return ToolUtils.md5(str);
    }

    /**
     * 判断token是否合法
     * 
     * @param uid
     * @param time
     * @return
     */
    public TokenModel verifyToken(String uid, long time, String sign, CodeData cd) {
        // 判断时间是否过期
        long curTime = System.currentTimeMillis() / 1000;
        if (Math.abs(curTime - time) > URL_REQUEST_TIMEOUT) {
            cd.setMsg("error timestamp");
            cd.setCode(TGCode.CODE_ERROR_TIMESTAMP);
            return null;
        }
        // 获取token
        TokenModel ret = this.getTokenModel(TOKEN_BUS + ":" + uid);
        if (ret == null) {
            cd.setCode(TGCode.CODE_ERROR_KEY);
            cd.setMsg("error key");
            return null;
        }
        // 判断签名
        String newSign = signUrl(uid, ret.getToken(), String.valueOf(time));
        if (!newSign.equalsIgnoreCase(sign)) {
            cd.setCode(TGCode.CODE_ERROR_URLSIGN);
            cd.setMsg("error sign");
            return null;
        }
        cd.setCode(TGCode.CODE_ERROR_NONE);
        cd.setMsg("ok");
        return ret;
    }

    /**
     * 判断是否有数据集权限
     * 
     * @param tm
     * @param modid
     * @param perm
     * @return 0=无权限 1=有权限
     */
    public int hasPermission(TokenModel tm, String modid, int perm) {
        if (tm == null) {
            return 0;
        }
        List<ModelAndPerm> list = tm.getPerm();
        if (list == null) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < list.size(); i++) {
            ModelAndPerm uperm = list.get(i);
            if (modid.equals(uperm.getModid())) {
                if ((perm & uperm.getPerm()) > 0) {
                    ret = 1;
                } else {
                    ret = 0;
                }
                break;
            }
        }

        return ret;
    }

    /**
     * 判断token是否合法
     * 
     * @param uid
     * @param time
     * @return
     */
    public TokenModel verifyToken(String uid, String time, String sign) {
        // 判断时间是否过期
        if (time == null || time.length() == 0) {
            throw new TgException(TgCode.CODE_ERROR_TIMESTAMP);
        }
        long curTime = System.currentTimeMillis() / 1000;
        long tz = Long.valueOf(time).longValue();
        if (Math.abs(curTime - tz) > URL_REQUEST_TIMEOUT) {
            throw new TgException(TgCode.CODE_ERROR_TIMESTAMP);
        }
        // 获取token
        TokenModel ret = this.getTokenModel(TOKEN_BUS + ":" + uid);
        if (ret == null) {
            throw new TgException(TgCode.CODE_ERROR_TOKEN);
        }
        // 判断签名
        String newSign = signUrl(uid, ret.getToken(), String.valueOf(time));
        if (!newSign.equalsIgnoreCase(sign)) {
            throw new TgException(TgCode.CODE_ERROR_URLSIGN);
        }
        return ret;
    }
    
    /**
     * 将http请求头中的身份信息转为对象 base64编码
     * @param baseStr 格式 = Basic eyJ1aWQiOiJjOTNiMmIwOTBhYT...
     * @return
     */
    public TgAuth base2Auth(String baseStr) {
        // 将base64的字符串转为TgAuth结构
        if (null == baseStr) {
            return null;
        }
        // 跳掉头部 Basic
        int i = baseStr.indexOf("Basic ");
        if (i != -1) {
            baseStr = baseStr.substring(6, baseStr.length());
        }
        // base64解码
        byte[] bData = Base64.getDecoder().decode(baseStr);
        String sData = new String(bData);
        System.out.println(sData);
        return JsonUtils.str2Obj(sData, TgAuth.class);
    }

}
