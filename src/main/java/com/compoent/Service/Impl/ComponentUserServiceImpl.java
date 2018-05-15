package com.compoent.Service.Impl;

import com.compoent.Service.ComponentUserService;
import com.compoent.dao.ComponentUserMapper;
import com.compoent.entity.ComponentUser;
import com.compoent.entity.ComponentUserExample;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by fx on 2018/5/15.
 */
@Service
@AllArgsConstructor
public class ComponentUserServiceImpl implements ComponentUserService {

    private ComponentUserMapper componentUserMapper;

    @Override
    public ComponentUser selectOne(String userName, String password, String roles) {

        ComponentUserExample componentUserExample = new ComponentUserExample();
        ComponentUserExample.Criteria criteria = componentUserExample.createCriteria();

        criteria.andPasswordEqualTo(password).andUserNameEqualTo(userName).andUserRoleEqualTo(roles);
        List<ComponentUser> componentUsers = componentUserMapper.selectByExample(componentUserExample);
        ComponentUser componentUser = new ComponentUser();
        if(!CollectionUtils.isEmpty(componentUsers)){

            componentUser = componentUsers.get(0);
        }
        return componentUser;
    }
}
