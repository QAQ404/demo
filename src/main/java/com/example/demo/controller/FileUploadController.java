package com.example.demo.controller;


import com.example.demo.pojo.Result;
import com.example.demo.untils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {


    @PostMapping("/upload")//文件大小要小于1M
    public Result<String> upload(MultipartFile file) throws Exception {
        String originalFilename= file.getOriginalFilename();
        String filename = UUID.randomUUID().toString() +
                originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存到本地
//        String url = "C:\\Users\\heqia\\Desktop\\file\\"+filename;
//        file.transferTo(new File("C:\\Users\\heqia\\Desktop\\file\\"+filename));
        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
