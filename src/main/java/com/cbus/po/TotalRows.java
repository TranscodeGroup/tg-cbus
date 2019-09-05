package com.cbus.po;

import java.util.List;

/**
 * EasyUI表的数据格式
 * @author zhen.lin
 * @data   2018年1月30日 下午9:39:14 
 */
public class TotalRows {

    private int total;
    private List<?> rows;
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
