package com.cbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbus.mapper.DatasetMapper;
import com.cbus.mapper.RuleMapper;
import com.cbus.po.DatasetVo;

@Service
public class DatasetServiceImpl implements DatasetService {

    @Autowired
    private DatasetMapper datasetMapper;
    
    @Autowired
    private RuleMapper ruleMapper;
    
    @Override
    public List<DatasetVo> getData(DatasetVo datasetVo) throws Exception {
        return datasetMapper.getData(datasetVo);
    }
    
    @Override
    public int delRecord(DatasetVo datasetVo) throws Exception {
        return datasetMapper.delRecord(datasetVo);
    }


    @Override
    public int updateRecord(DatasetVo datasetVo) throws Exception {
        return datasetMapper.updateRecord(datasetVo);
    }


    @Override
    public int addRecord(DatasetVo datasetVo) throws Exception {
        String val = "DST";
        int id = ruleMapper.getRuleId(val);
        val = String.format("DST%06d", id);
        datasetVo.setGid(val);
        return datasetMapper.addRecord(datasetVo);
    }

    @Override
    public DatasetVo getDataByDsId(String gid) throws Exception {
        DatasetVo datasetVo = new DatasetVo();
        datasetVo.setGid(gid);
        List<DatasetVo> list = datasetMapper.getData(datasetVo);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
