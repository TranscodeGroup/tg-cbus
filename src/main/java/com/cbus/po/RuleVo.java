package com.cbus.po;

/**
 * 编码规则表Vo结构
 * @author zhen.lin
 * @date 2019年5月30日
 */
public class RuleVo extends Rule {

    private String orderby;
    private String likename;
    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
    public String getLikename(){
        return likename;
    }
    public void setLikename(String likename){
        this.likename=likename;
    }
}
