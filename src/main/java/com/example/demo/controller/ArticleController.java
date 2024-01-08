package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.PageBean;
import com.example.demo.pojo.Result;
import com.example.demo.service.ArticleService;
import com.example.demo.untils.JwtUtil;
import com.example.demo.untils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/article")
@Validated
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

    @GetMapping("/detail")
    public Result<Article> detail(@RequestParam int id){
        Article article = articleService.detail(id);
        if (article == null) return Result.error("不存在此文章");
        return Result.success(article);
    }

    @DeleteMapping
    public Result delete(@NotNull int id){
        Article article = articleService.detail(id);
        if (article == null) return Result.error("不存在此文章");
        articleService.delete(id);
        return Result.success("删除成功");
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Article.Update.class) Article article){
        if (articleService.detail(article.getId())==null) return Result.error("此文章不存在");
        article.setUpdateTime(LocalDateTime.now());
        articleService.update(article);
        return Result.success("update very yes");
    }
}
