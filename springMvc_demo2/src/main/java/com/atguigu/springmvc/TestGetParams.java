package com.atguigu.springmvc;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class TestGetParams {
    //通过原生servelt来获取请求参数
    @RequestMapping(value="/testServeltAPI")
    public String testServeltAPI(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + "," + password);
        return "success";
    }

    @RequestMapping(value="/testParam")
    //多个同名的请求参数可以用一个字符串接受,多个value值中间用,隔开;也可以用一个字符串数组来接受
    public String testParam(@RequestParam(value="username",defaultValue="MaYun") String username, String password, String[] hobby){
        System.out.println(username + "," + password+","+ Arrays.toString(hobby));
        return "success";
    }

    //通过实体类来获取请求参数,要求name属性值与pojo的属性名一致
    @RequestMapping(value="/testpojo")
    public String testPojo(User user){
        System.out.println(user);
        return "success";
    }
}
