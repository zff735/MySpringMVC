package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {
    //@RequestBody获取请求体信息,只有post方法才有请求体
    @RequestMapping(value ="testRequestBody",method= RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "success";
    }

    //获取请求报文,getHeaders()获取请求头,getBody()获取请求体
    @RequestMapping(value="/testRequestEntity",method=RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity){
        HttpHeaders headers = requestEntity.getHeaders();
        String body = requestEntity.getBody();
        System.out.println(headers);
        System.out.println(body);
        return "success";
    }

    @RequestMapping(value="/testResponseBody")
    @ResponseBody
//    @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
    public String testResponseBody(){
        return "success";
    }

    //响应java对象
    @RequestMapping(value="/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        //响应的是json格式的字符串
        return new User(1001,"mahuateng","98765");
    }

    @RequestMapping(value="/testAjax")
    @ResponseBody
    public User testAjax(String name,String password){
        System.out.println(name + "," + password);
        return new User(1001,"mahuateng","98765");
    }
}
