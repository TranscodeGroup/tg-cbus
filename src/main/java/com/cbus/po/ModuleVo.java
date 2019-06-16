package com.cbus.po;

/**
 * 模块表Vo结构
 * @author zhen.lin
 * @date 2019年5月9日
 */
public class ModuleVo extends Module {
    // 排序条件
    private String orderby;

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

}
