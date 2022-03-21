package com.atguigu.springmvc.file;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileDown {
    /*文件下载
    * 1.获取文件在服务器中的真实路径
    * 2.创建输入流,把流读到字节数组中
    * 3.自定义响应报文
    * 4.创建ResponseEntity对象
    * 5.将ResponseEntity对象返回
    * */
    @RequestMapping(value="/fileDown")
//    可以改的地方只有文件名
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("static/img/1.png");
//        String realPath1 = servletContext.getRealPath("");
//        System.out.println(realPath);
//        System.out.println(realPath1);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字,filename为下载到磁盘中文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.i.png");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping(value="/fileup")
    public String fileup(MultipartFile photo,HttpSession session) throws IOException {
//        获取服务器中的img目录路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("static/img");
//        获取上传的文件名,将文件的后缀名得到,通过UUID来为文件重新命名(防止文件在img目录下出现重名)
        String oName = photo.getOriginalFilename();
        String substring = oName.substring(oName.lastIndexOf("."));
        String s = UUID.randomUUID().toString();
        String filename=s+substring;//得到的文件新名称
//        判断服务器中该目录是否存在
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
//        将文件上传到服务器的全路径名中
        String finalPath=realPath+File.separator+filename;
        photo.transferTo(new File(finalPath.replaceAll("-","")));
        return "success";
    }
}
