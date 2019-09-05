package com.cbus.utils;

/**
 * 自定义错误码
 * <p>
 * 1000 到 1099 为公用错误码
 * <p>
 * 1100 以上为业务相关
 * 
 * @author eason
 * @date 2019/08/14
 */
public enum TgCode {
    /**
     * 正常 无错误
     */
    CODE_ERROR_NONE(0, "ok"),

    /**
     * 未知错误
     */
    CODE_ERROR_UNKNOW(1000, "unknow error"),

    /**
     * token过期
     */
    CODE_ERROR_TOKEN(1001, "token expired"),

    /**
     * 时间戳错误
     */
    CODE_ERROR_TIMESTAMP(1002, "timestamp error"),

    /**
     * url签名错误
     */
    CODE_ERROR_URLSIGN(1003, "sign error"),

    /**
     * 查询必选条件丢失 参数错误
     */
    CODE_ERROR_PARAM(1004, "param error"),

    /**
     * 没有权限
     */
    CODE_ERROR_PERMISSION(1005, "permission error"),

    /**
     * 超时
     */
    CODE_ERROR_TIMEOUT(1006, "timeout"),

    /**
     * 繁忙
     */
    CODE_ERROR_BUSY(1007, "busy"),

    /**
     * 用户名或密码错误
     */
    CODE_ERROR_PASSWORD(1100, "password error"),

    /**
     * 正在处理中
     */
    CODE_ERROR_PROCESS(1101, "process"),

    /**
     * 验证码错误
     */
    CODE_ERROR_VCODE(1102, "code error"),

    /**
     * 太频繁操作
     */
    CODE_ERROR_OFTEN(1103, "often"),

    /**
     * 账号不存在
     */
    CODE_ERROR_NOACCOUNT(1104, "no account"),

    /**
     * 邮箱不是账号绑定的邮箱
     */
    CODE_ERROR_NOBINDEMAIL(1105, "no binde email"),

    /**
     * 账号已被注册
     */
    CODE_ERROR_HASACCOUNT(1106, "has account"),

    /**
     * 邮箱已被使用
     */
    CODE_ERROR_HASEMAIL(1107, "has email"),

    /**
     * 账号已登陆
     */
    CODE_ERROR_LOGINED(1108, "logined"),

    /**
     * 账号过期
     */
    CODE_ERROR_ACCOUNTEXP(1109, "account exp")

    ;

    /**
     * 错误码
     */
    private int id;
    /**
     * 错误码对应消息
     */
    private String msg;

    TgCode(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TgCode [id=" + id + ", msg=" + msg + "]";
    }

}
