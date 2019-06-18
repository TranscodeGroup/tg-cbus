package com.cbus.po;

/**
 * 编码规则表结构
 * @author zhen.lin
 * @date 2019年5月30日
 */
public class Rule {

    private Integer id;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 后缀
     */
    private Integer suffix;
    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrefix() {
        if (prefix != null)
            prefix = prefix.trim();
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getSuffix() {
        return suffix;
    }

    public void setSuffix(Integer suffix) {
        this.suffix = suffix;
    }

    public String getRemark() {
        if (remark != null)
            remark = remark.trim();
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
