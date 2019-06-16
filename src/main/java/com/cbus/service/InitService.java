package com.cbus.service;

import java.util.List;
import com.cbus.token.ModelAndPerm;

public interface InitService {

    /**
     * 获取用户关联的模块与权限
     * @param uid
     * @return
     * @throws Exception
     */
    public List<ModelAndPerm> Initialize(String uid) throws Exception;
}
