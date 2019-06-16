package com.cbus.po.param;

import java.util.List;

/**
 * 导出参数
 * 
 * @author zhen.lin
 * @date 2019年6月14日
 */
public class ExportParam {

    // 导出格式 xls=excel doc=word opdf=pdf
    private String fmt;
    // 地理解析 0=不解析 1=解析
    private int geo;
    // 要导出的文件名
    private String filename;
    // 列名映射
    private List<ColumnMap> colmap;

    public String getFmt() {
        if (this.fmt == null)
            this.fmt = "XLS";
        return fmt.toUpperCase();
    }

    public void setFmt(String fmt) {
        this.fmt = fmt;
    }

    public int getGeo() {
        return geo;
    }

    public void setGeo(int geo) {
        this.geo = geo;
    }

    public String getFilename() {
        if (filename == null)
            filename = String.valueOf(System.currentTimeMillis());
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<ColumnMap> getColmap() {
        return colmap;
    }

    public void setColmap(List<ColumnMap> colmap) {
        this.colmap = colmap;
    }

}
