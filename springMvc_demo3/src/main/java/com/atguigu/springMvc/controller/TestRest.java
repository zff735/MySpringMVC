package com.atguigu.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestRest {
//    所有方法根据value和method来匹配
    //1.查询所有用户信息
    @RequestMapping(value="/user",method= RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }
    //2.根据id值来查询用户信息
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public String getOneUser(@PathVariable("id") String id ){
        System.out.println("获取一个用户信息,id为"+id);
        return "success";
    }
    //3.添加一个用户信息
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public String addOneUser(String username,String password){
        System.out.println("添加一个用户,username=" + username + ",password=" + password);
        return "success";
    }
    //4.更改用户信息
    @RequestMapping(value="/user",method=RequestMethod.PUT)
    public String update(String username,String password){
        System.out.println("更改一个用户,username=" + username + ",password=" + password);
        return "success";
    }
}
