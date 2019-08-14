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
