package com.jxnu.controller;

import com.jxnu.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {
    @RequestMapping(value ="/getJson")
    @ResponseBody
    public User getJson(@RequestBody User user){
        return user;
    }

    @RequestMapping(value="/topage")
    public String topage(){
        return "getjson";
    }
}
