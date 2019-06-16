package com.cbus.po;

/**
 * 模块表结构
 * 
 * @author zhen.lin
 * @date 2019年5月9日
 */
public class Module {
    
    private Integer id;
    // 模块id
    private String gid;
    // 上级id
    private String pid;
    // 可操作 按位
    private Integer opt;
    // 是否受控 0=普通用户、管理员可见 1=超级管理员可见
    private Integer isctrl;
    // 图标类名
    private String icon;
    // url路径
    private String path;
    // vue文件路径
    private String vue;
    // 是否隐藏 0=否 1=是
    private Integer hide;
    // 备注
    private String remark;
    // 排序
    private int sortid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getOpt() {
        return opt;
    }

    public void setOpt(Integer opt) {
        this.opt = opt;
    }

    public Integer getIsctrl() {
        return isctrl;
    }

    public void setIsctrl(Integer isctrl) {
        this.isctrl = isctrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

}
