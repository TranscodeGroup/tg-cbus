package com.cbus.mapper;

import java.util.List;

import com.cbus.token.ModelAndPerm;

public interface InitMapper {
    
    public List<ModelAndPerm> Initialize(String uid) throws Exception;
}
