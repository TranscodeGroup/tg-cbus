package com.cbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbus.mapper.InitMapper;
import com.cbus.token.ModelAndPerm;


@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private InitMapper initMapper;

    @Override
    public List<ModelAndPerm> Initialize(String uid) throws Exception {
        return initMapper.Initialize(uid);
    }
    
}
