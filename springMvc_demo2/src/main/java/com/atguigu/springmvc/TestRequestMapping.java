package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value ="order")
public class TestRequestMapping {
    @RequestMapping(value ={"/testrequestmapping","/test"},method= {RequestMethod.GET})
    public String success(){
        return "success";
    }

    @RequestMapping(value ={"/testrequestmapping","/test"},method={RequestMethod.POST})
    public String success1(){
        return "success";
    }

    //params必须满足所有条件,请求中可以有多,但一定不能少
    //value满足数组中的一个即可
    //method满足一个即可
    @RequestMapping(value="/testParams",params={"username","!password"})
    public String TestParams(){
        return "success";
    }

    //ant风格路径
    //@RequestMapping(value="/a?a")//?表示一个字符,但不能是/?这种特殊字符
    //@RequestMapping(value="/a*a")//*表示一个或多个字符,也可以没有
    @RequestMapping(value="/**/aa")//表示多层目录,或者没有
    public String TestAnt(){
        return "success";
    }

    //rest风格传参  {}:表示占位符,在访问路径上必须有这个参数
    @RequestMapping(value="/testPath/{id}/{username}")
    public String TestPath(@PathVariable("id")String id,@PathVariable("username")String username){
        System.out.println(id + "," + username);
        return "success";
    }

    @RequestMapping(value="/param")
    public String testParam(){
        return "testParams";
    }
}
