package com.gene.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来测试RestController 返回值
 * @author gene
 *
 */
@RestController
@RequestMapping("home")
public class HomeController {


    @RequestMapping("/index")
    public String home(){
        return "Hello World!";
    }
}
