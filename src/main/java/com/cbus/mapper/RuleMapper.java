package com.cbus.mapper;

import java.util.List;

import com.cbus.po.RuleVo;

public interface RuleMapper {

    /**
     * 查询表数据
     * @param ruleVo
     * @return
     * @throws Exception
     */
    public List<RuleVo> getData(RuleVo ruleVo) throws Exception;
    
    /**
     * 更新表数据
     * @param ruleVo
     * @return
     * @throws Exception
     */
    public int updateRecord(RuleVo ruleVo) throws Exception; 
    
    /**
     * 新增表数据
     * @param ruleVo
     * @return
     * @throws Exception
     */
    public int addRecord(RuleVo ruleVo) throws Exception;
    
    /**
     * 删除表数据
     * @param ruleVo
     * @return
     * @throws Exception
     */
    public int delRecord(RuleVo ruleVo) throws Exception;
    
}
