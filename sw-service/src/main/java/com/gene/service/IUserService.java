package com.gene.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gene.dao.entity.User;

public interface IUserService extends IService<User> {

    void addUser(User user)throws Exception;

    void updateUser(User user)throws Exception;

//    User getUserByOpenId(String openId)throws Exception;

    User getUserByRawHeadImgUrl(String rawHeadImgUrl)throws Exception;

}
