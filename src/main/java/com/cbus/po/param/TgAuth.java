package com.cbus.po.param;

/**
 * 身份信息结构
 * @author zhen.lin
 * @date 2019年8月14日
 */
public class TgAuth {

    // 用户id
    private String uid;
    // 时间戳 单位秒
    private long time;
    // 签名
    private String sign;
    
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    
    
}
