package com.gene.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 测试html路径页面是否能挣钱访问
 * @author gene
 *
 */
@Controller
//@RequestMapping("/page")
public class PageController {

    @RequestMapping("/index")
    public String index(HashMap<String,Object> map){

        map.put("hello", "欢迎进入HTML页面！HELLO WORLD!!");
        return "/index";
    }
}
