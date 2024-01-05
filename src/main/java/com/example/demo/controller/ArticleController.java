package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.PageBean;
import com.example.demo.pojo.Result;
import com.example.demo.service.ArticleService;
import com.example.demo.untils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article){

        articleService.add(article);
        return Result.success("add yes");
    }

    @GetMapping
    public Result<PageBean<Article>> list(int pageNum,int pageSize
                                    ,@RequestParam(required = false) String categoryId
                                    ,@RequestParam(required = false) String state){
        PageBean<Article> pageBean = articleService.list(pageNum,pageSize,categoryId,state);

        return Result.success(pageBean);
    }


}
