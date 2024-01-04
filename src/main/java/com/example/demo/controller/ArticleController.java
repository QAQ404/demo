package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.untils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token,
                               HttpServletResponse response*/){

      /*  try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            return Result.success("所以的文章数据..");
        } catch (Exception e) {
            response.setStatus(401);
            return Result.error("未登录");
        }*/
        return Result.success("所有的文章数据..");
    }
}
