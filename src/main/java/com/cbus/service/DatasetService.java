package com.cbus.service;

import java.util.List;

import com.cbus.po.DatasetVo;

public interface DatasetService {

    /**
     * 查询表数据
     * @param datasetVo
     * @return
     * @throws Exception
     */
    public List<DatasetVo> getData(DatasetVo datasetVo) throws Exception;
    
    /**
     * 删除表数据
     * @param datasetVo
     * @return
     * @throws Exception
     */
    public int delRecord(DatasetVo datasetVo) throws Exception;

    /**
     * 更新表数据
     * @param datasetVo
     * @return
     * @throws Exception
     */
    public int updateRecord(DatasetVo datasetVo) throws Exception;

    /**
     * 添加表数据
     * @param datasetVo
     * @return
     * @throws Exception
     */
    public int addRecord(DatasetVo datasetVo) throws Exception;
    
    /**
     * 通过模块id获取数据源信息
     * @param gid 表数据源id
     * @return
     * @throws Exception
     */
    public DatasetVo getDataByDsId(String gid) throws Exception;
}
