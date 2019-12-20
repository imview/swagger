package com.gene.api.controller;

import com.gene.common.ServiceResultT;
import com.gene.dao.entity.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "user")
@Api(value = "user", description = "用户相关接口", produces = MediaType.ALL_VALUE)
public class UserController {  //extends BaseController
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

//    @Autowired
//    UserService userService;

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ServiceResultT<User> getUserInfo(){

        return null;
    }
}
