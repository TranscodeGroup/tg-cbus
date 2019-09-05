package com.cbus.po;

/**
 * 带错误码的数据类 用于返回给客户端
 * @author zhen.lin
 * @data   2017年6月22日 下午1:43:29
 */
public class CodeData {

    /**
     * 返回码  
     * 0    正确  
     * 1000 未知错误 一般服务器报错时的值 
     * 1000以上, 具体的错误, 每个code对应一种错误, 不重复; 具体表示什么服务器定
     *
     * 以下是通用错误
     * 1001 KEY错误
     * 1002 时间戳错误
     * 1003 签名错误
     * 1004 参数错误
     * 
     * 1011 新增失败
     * 1012 更新失败
     * 1013 删除失败
     *
     * 以下是业务相关错误
     * 1100 用户名或密码错误
     */
    private int code;
    /**
     * 描述信息, 描述错误原因，如"success" 成功, "error" 错误
     */
    private String msg;
    /**
     * 数据，json格式, 值可以是number/boolean/array/object/string, 不能为null，至少是{}
     * 根据不同的业务进行相应的解包
     */
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
