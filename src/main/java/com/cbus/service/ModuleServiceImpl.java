package com.cbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbus.mapper.ModuleMapper;
import com.cbus.po.ModuleVo;

/**
 * 模块表接口实现
 * @author zhen.lin
 * @date 2019年5月9日
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;
    
        
    @Override
    public List<ModuleVo> getData(ModuleVo moduleVo) throws Exception {
        return moduleMapper.getData(moduleVo);
    }

    @Override
    public int updateRecord(ModuleVo moduleVo) throws Exception {
        return moduleMapper.updateRecord(moduleVo);
    }

    @Override
    public int addRecord(ModuleVo moduleVo) throws Exception {
        return moduleMapper.addRecord(moduleVo);
    }

    @Override
    public int delRecord(ModuleVo moduleVo) throws Exception {
        return moduleMapper.delRecord(moduleVo);
    }
    
    
}
