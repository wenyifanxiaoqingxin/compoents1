package com.compoent.Service;

import com.compoent.entity.ComponentUser;

/**
 * Created by fx on 2018/5/15.
 */
public interface ComponentUserService {

    ComponentUser selectOne(String userName, String password,String roles);
}
