package com.cbus.service;

import java.util.List;

import com.cbus.po.RuleVo;

public interface RuleService {
    
    public List<RuleVo> getData(RuleVo ruleVo) throws Exception;
    
    public int getRuleId(String prefix) throws Exception;
    
    public int updateRecord(RuleVo ruleVo) throws Exception;
    
    public int addRecord(RuleVo ruleVo) throws Exception;
    
    public int delRecord(RuleVo ruleVo) throws Exception;

}
