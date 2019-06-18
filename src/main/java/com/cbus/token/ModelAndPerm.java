package com.cbus.token;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模块权限
 * 
 * @author zhen.lin
 * @date 2019年4月28日
 */
public class ModelAndPerm {

    // id
    private Integer id;
    // 模块id
    @JsonProperty("index")
    private String modid;
    // 上级节点
    private String pid;
    // icon
    private String icon;
    // vue
    private String vue;
    // path
    private String path;
    // 可用权限 按位运算 4字节 低位在前 低2个字节系统使用 高2个字节自定义
    // 00000000 00000000 00000000 00000000 0 无
    // 00000000 00000000 00000000 00000001 1 可读
    // 00000000 00000000 00000000 00000010 2 新增
    // 00000000 00000000 00000000 00000100 4 编辑
    // 00000000 00000000 00000000 00001000 8 删除
    // 00000000 00000000 00000000 00010000 16 导入
    // 00000000 00000000 00000000 00100000 32 导出
    // 00000000 00000000 00000000 01000000 64 审核
    // 00000000 00000000 00000000 10000000 128 取消
    private int opt;
    // 用户拥有的权限
    private int perm;
    // 是否隐藏
    private int hide;
    // 是否可关闭
    private int closable;

    // 关联的数据集 数组格式 个别窗口可能拥有多个数据集
    private List<ModelDataset> dsids;
    // 子节点
    private List<ModelAndPerm> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModid() {
        return modid;
    }

    public void setModid(String modid) {
        this.modid = modid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getClosable() {
        return closable;
    }

    public void setClosable(int closable) {
        this.closable = closable;
    }

    public List<ModelDataset> getDsids() {
        return dsids;
    }

    public void setDsids(List<ModelDataset> dsids) {
        this.dsids = dsids;
    }

    public List<ModelAndPerm> getChildren() {
        return children;
    }

    public void setChildren(List<ModelAndPerm> children) {
        this.children = children;
    }

}