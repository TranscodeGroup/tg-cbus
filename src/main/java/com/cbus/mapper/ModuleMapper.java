package com.cbus.mapper;

import java.util.List;

import com.cbus.po.ModuleVo;

public interface ModuleMapper {

    /**
     * 查询表数据
     * 
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public List<ModuleVo> getData(ModuleVo moduleVo) throws Exception;
    /**
     * 更新
     */
    public int updateRecord(ModuleVo moduleVo) throws Exception; 
    /**
     * 添加
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int addRecord(ModuleVo moduleVo) throws Exception;
    /**
     * 删除
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int delRecord(ModuleVo moduleVo) throws Exception;
}
