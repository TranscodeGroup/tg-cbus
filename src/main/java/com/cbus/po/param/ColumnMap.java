package com.cbus.po.param;

/**
 * 表头字段映射结构
 * 
 * @author zhen.lin
 * @date 2019年6月14日
 */
public class ColumnMap {

    // 标题
    private String title;
    // 字段名
    private String field;
    // 对齐方式 0=默认  1=左对齐 2=居中 3=右对齐
    private int align = 0;
    // 宽度
    private int width = 100;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
