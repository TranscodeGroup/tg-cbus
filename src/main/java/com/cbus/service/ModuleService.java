package com.cbus.service;

import java.util.List;

import com.cbus.po.ModuleVo;

/**
 * 模块表接口
 * @author zhen.lin
 * @date 2019年5月9日
 */
public interface ModuleService {
    
    /**
     * 查询表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public List<ModuleVo> getData(ModuleVo moduleVo) throws Exception;
    
    /**
     * 更新表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int updateRecord(ModuleVo moduleVo) throws Exception; 
    
    /**
     * 添加表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int addRecord(ModuleVo moduleVo) throws Exception;
    
    /**
     * 删除表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int delRecord(ModuleVo moduleVo) throws Exception;
    
}
