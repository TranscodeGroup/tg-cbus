package com.cbus.token;

/**
 * 模块关联的数据集
 * @author zhen.lin
 * @date 2019年5月9日
 */
public class ModelDataset {
    private int id;
    private String dsid;
    private int dtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDsid() {
        return dsid;
    }

    public void setDsid(String dsid) {
        this.dsid = dsid;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }
}
