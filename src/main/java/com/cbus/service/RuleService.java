package com.cbus.service;

import java.util.List;

import com.cbus.po.RuleVo;

public interface RuleService {
    
    /**
     * 查询表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public List<RuleVo> getData(RuleVo ruleVo) throws Exception;
    
    /**
     * 更新表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int updateRecord(RuleVo ruleVo) throws Exception;
    
    /**
     * 添加表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int addRecord(RuleVo ruleVo) throws Exception;
    
    /**
     * 删除表数据
     * @param moduleVo
     * @return
     * @throws Exception
     */
    public int delRecord(RuleVo ruleVo) throws Exception;
    
    /**
     * 根据前缀获取编码值
     * @param prefix
     * @return
     * @throws Exception
     */
    public int getRuleId(String prefix) throws Exception;

}
