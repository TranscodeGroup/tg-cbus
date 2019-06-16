package com.cbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbus.mapper.DatasetMapper;
import com.cbus.po.DatasetVo;

@Service
public class DatasetServiceImpl implements DatasetService {

    @Autowired
    private DatasetMapper datasetMapper;
    
    @Override
    public List<DatasetVo> getData(DatasetVo DatasetVo) throws Exception {
        return datasetMapper.getData(DatasetVo);
    }
    
    @Override
    public int delRecord(DatasetVo DatasetVo) throws Exception {
        return datasetMapper.delRecord(DatasetVo);
    }


    @Override
    public int updateRecord(DatasetVo DatasetVo) throws Exception {
        return datasetMapper.updateRecord(DatasetVo);
    }


    @Override
    public int addRecord(DatasetVo DatasetVo) throws Exception {
        return datasetMapper.addRecord(DatasetVo);
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
