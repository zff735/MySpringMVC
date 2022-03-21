package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value ="/")//将路径"/"和index.html联系起来
    public String index(){
        return "index";//返回视图名称
    }
    
    @RequestMapping(value ="/target")//将路径"/target"和target.html联系起来
    public String target(){
        return "target";
    }
}
