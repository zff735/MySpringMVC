package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value ="/user")
public class TestController {
    @RequestMapping(value ="/")
    public String index(){
        return "index";
    }
}
