package com.cbus.po;

/**
 * 数据集表结构
 * @author zhen.lin
 * @date 2019年5月9日
 */
public class Dataset {

    private Integer id;
    
    // 数据id
    private String gid;
    // 模块ID 表示属于哪个模块 对应t_module表
    private String modid;
    // 数据编号 默认 0
    private Integer dtype;
    // 对应的服务名 区分大小写
    private String title;

    private String sorter;
    
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

    public String getModid() {
        if (modid != null)
            modid = modid.trim();
        return modid;
    }

    public void setModid(String modid) {
        this.modid = modid;
    }

    public Integer getDtype() {
        return dtype;
    }

    public void setDtype(Integer dtype) {
        this.dtype = dtype;
    }

    public String getTitle() {
        if (title != null)
            title = title.trim();
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 排序字段，因为xml中使用${sorter}，会有可能被注入，在这里要特殊处理一下
     * 
     * @return
     */
    public String getSorter() {
        return sorter;
    }

    public void setSorter(String sorter) {
        this.sorter = sorter;
    }

}
