package com.gene.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gene.dao.entity.User;
import com.gene.dao.mapper.UserMapper;
import com.gene.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {


    @Override
    @Transactional
    public void addUser(User user)throws Exception{
        user.setCreateTime(new Date());
        save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user)throws Exception{
        user.setUpdateTime(new Date());
        updateById(user);
    }

    @Override
    public User getUserByRawHeadImgUrl(String rawHeadImgUrl)throws Exception {
        return this.baseMapper.getUserByRawHeadImgUrl(rawHeadImgUrl);
    }
}
