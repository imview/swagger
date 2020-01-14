package com.gene.api.controller;

import com.gene.common.ServiceResultT;
import com.gene.dao.entity.User;
import com.gene.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ValueExp;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "user")
@Api(value = "user", description = "用户相关接口", produces = MediaType.ALL_VALUE)
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private IUserService userService;

//
//    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
//    public ServiceResultT<User> getUserInfo(){
//        User usr = userService.getById("001");
//        ServiceResultT<User> resultT = new ServiceResultT<>();
//        Map<String ,User> map = new HashMap();
//        map.put("usr",usr);
//        resultT.setDicData(map);
//        return resultT;
//    }

    @ResponseBody
    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息",notes="返回用户信息（opendId）", produces = MediaType.ALL_VALUE)
    public ServiceResultT<User> getUserInfo(
//            @ApiParam(value = "code-获取access_token的code", required = true,name="code")
//            String code
    )throws Exception{
        User usr = userService.getById("001");
        ServiceResultT<User> resultT = new ServiceResultT<>();
        Map<String ,User> map = new HashMap();
        map.put("usr",usr);
        resultT.setDicData(map);
        return resultT;
    }
}
