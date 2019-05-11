package com.example.springbootupload.fs;

import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class FileController {
    @Autowired
    private CommonFileUtil fileUtil;

    @Autowired
    private FdfsConfig fdfsConfig;

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    // 跳转上传页面
    @RequestMapping("/goIndex")
    public String goIndex(){
        logger.info("进入主页面");
        return "/file";
    }

    // 使用fastdfs进行文件上传
    @RequestMapping("/uploadFileToFast")
    public String uoloadFileToFast(@RequestParam("fileName")MultipartFile file, RedirectAttributes attributes) throws IOException{

        if(file.isEmpty()){
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        String url = fdfsConfig.getResHost()+path;
        attributes.addAttribute("url", url);
        return "redirect:/success";
    }

    // 跳转成功页面
    @RequestMapping("/success")
    public String success(HttpServletRequest request){
        request.setAttribute("imgUrl", request.getParameter("url"));
        logger.info(request.getParameter("url"));
        logger.info("进入上传成功页面");
        return "/success";
    }

}