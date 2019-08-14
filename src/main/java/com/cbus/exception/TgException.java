package com.cbus.exception;

import com.cbus.utils.TgCode;

/**
 * 自定义异常
 * 
 * @author eason
 * @date 2019/08/07
 */
public class TgException extends RuntimeException {

    private static final long serialVersionUID = -4150938742931389996L;
    /**
     * 异常代码,参见 #{TgCode}
     */
    private TgCode code;
    /**
     * 异常描述
     */
    private String msg;

    /**
     * 
     * @param code
     *            自定义异常编码
     * @msg 自定义异常编码消息
     */
    public TgException(TgCode code) {
        this.code = code;
        this.msg = code.getMsg();
    }

    /**
     * 
     * @param code
     *            自定义异常编码
     * @param msg
     *            重定义异常编码消息
     */
    public TgException(TgCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code.getId();
    }

    public void setCode(TgCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}