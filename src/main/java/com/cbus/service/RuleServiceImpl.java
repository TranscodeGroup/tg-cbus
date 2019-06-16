package com.cbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbus.mapper.RuleMapper;
import com.cbus.po.RuleVo;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper ruleMapper;
    
    @Override
    public List<RuleVo> getData(RuleVo ruleVo) throws Exception {
        
        return ruleMapper.getData(ruleVo);
    }
    
//    public int getRuleId(String prefix) throws Exception {
//        return ruleMapper.getRuleId(prefix);
//    };
    
    @Override
    public int updateRecord(RuleVo ruleVo) throws Exception {
        return ruleMapper.updateRecord(ruleVo);
    }
    
    @Override
    public int addRecord(RuleVo ruleVo) throws Exception {
        return ruleMapper.addRecord(ruleVo);
    };
    
    @Override
    public int delRecord(RuleVo ruleVo) throws Exception {
        return ruleMapper.delRecord(ruleVo);
    }

    @Override
    public int getRuleId(String prefix) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

}
