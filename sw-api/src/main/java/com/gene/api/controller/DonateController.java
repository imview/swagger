package com.gene.api.controller;


import com.gene.common.ServiceResult;
import com.gene.dao.entity.Donate;
import com.gene.dao.entity.User;
import com.gene.service.IDonateService;
import com.gene.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping(value = "donate")
@Controller
@Api(value = "donate", description = "捐赠接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class DonateController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IDonateService donateService;

    /**
     * 保存捐款记录2001
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="donate",method = RequestMethod.POST)
    @ApiOperation(value="2001保存捐款记录",notes="2001", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult donate(
            @ApiParam(value = "openId=用户在对应公众号下唯一id", required = true,name="openId")
                    String openId,
            @ApiParam(value = "amount=捐款金额", required = true,name="amount")
                    Double amount,
            @ApiParam(value = "name=捐款人姓名",name="name")
                    String name,
            @ApiParam(value = "mobile=捐款人手机号码",name="mobile")
                    String mobile,
            @ApiParam(value = "schoolClass=班期",name="schoolClass")
                    String schoolClass,
            @ApiParam(value = "period=期数",name="period")
                    String period) throws Exception{

        ServiceResult result = new ServiceResult();
        User userBO = userService.getById(openId);

        if(amount == null){
            result.failed("捐赠金额不能为空");
        }
        else if(amount  < 0.01){
            result.failed("捐赠金额不能小于0.01");
        }
        else if(amount  > 200000){
            result.failed("捐赠金额已超出限额，请再输入");
        }
        else if(name!= null && name.length() >= 25){
            result.failed("捐赠姓名，长度超长了");
        }
        else if(name!= null && !removeFourChar(name).equals(name)){
            result.failed("姓名可能包含非法字符，请重新输入。");
        }
        else if(StringUtils.isBlank(openId)){
            result.failed("openId不能为空");
        }
        else if (userBO == null){
            result.failed("获取微信用户失败");
        } else{


            Donate donateBO = new Donate();
            Map<String, Object> map = new HashMap<String, Object>();

            String donateId = UUID.randomUUID().toString();
            donateBO.setCreateTime(new Date());
            donateBO.setAmount(new BigDecimal(amount));
            donateBO.setMobile(mobile);
            donateBO.setSchoolClass(schoolClass);
            donateBO.setPeriod(period);
            donateBO.setUserName(name);
            donateBO.setId(donateId);

            donateBO.setNickName(userBO.getNickName());
            donateBO.setHeadImgUrl(userBO.getHeadImgUrl());
            donateBO.setOpenId(openId);

            result = donateService.addDonate(donateBO);
            if(result.getIsSuccess()){

                map.put("donateId", donateId);
                result.setDicData(map);
            }
        }


        return null;
    }


    /**
     * 移除 ： 0000
     * @param content
     * @return
     */
    public static String removeFourChar(String content){
        byte[] conbyte = content.getBytes();
        for (int i = 0; i < conbyte.length; i++) {
            if ((conbyte[i] & 0xF8) == 0xF0) {
                for (int j = 0; j < 4; j++) {
                    conbyte[i+j]=0x30;
                }

                i += 3;
            }
        }

        content = new String(conbyte);
        return content.replaceAll("0000", "");

    }
}
