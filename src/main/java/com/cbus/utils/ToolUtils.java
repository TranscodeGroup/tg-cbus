package com.cbus.utils;

import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class ToolUtils {
    /**
     * 获取uuid
     * 
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
    
    /**
     * 获取进程id
     * 
     * @return
     */
    public static int getPID() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        // get pid
        String pid = name.split("@")[0];
        return Integer.parseInt(pid);
    }
    
    /**
     * 获取访问的基础域名
     * @param request
     * @return
     */
//    public static String getBaseUrl(HttpServletRequest request) {
//        String sPort = "";
//        if (request.getServerPort() != 80)
//            sPort = ":" + String.valueOf(request.getServerPort());
//        return request.getScheme() + "://" + request.getServerName() + sPort;
//    }
    
    /**
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    /**
     * 简单的判断一下时间是否为时间戳
     * @param time
     * @return
     */
    public static boolean isTimestamp(String time) {
        if (time == null)
            return false;
        if (time.length() != 10)
            return false;
        if (!isNum(time))
            return false;
        byte[] b = time.getBytes();
        // 只认 1 2两个数字
        if ((b[0] < 49) || (b[0] > 51))
            return false;
        return true;
    }
    
    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String titleCase(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
    
    /**
     * 返回比较时间戳与当前服务器时间的时间差(单位秒)
     * @param targetTime
     * @return
     */
    public static long timeDiff(long targetTime) {
        return Math.abs((System.currentTimeMillis()/1000 - targetTime));
    }
    
    /**
     * 获取字符串md5值
     * @param context
     * @return 16进制小写字符串
     */
    public static String md5(String context) {
        MessageDigest md;
        byte md5buf[] = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update((context).getBytes("UTF-8"));
            md5buf = md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        
        }
        // 将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, md5buf).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code.toLowerCase();
    }
}
