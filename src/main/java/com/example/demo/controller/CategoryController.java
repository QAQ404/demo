package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Result;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success("yes");
    }

    @GetMapping
    public Result<List<Category>> list(){

        List<Category> cs =  categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam("id") int caid){
        Category cs =  categoryService.detail(caid);
        if(cs!=null) return Result.success(cs);
        return Result.error("不存在此类别");
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        category.setUpdateTime(LocalDateTime.now());
        categoryService.update(category);
        return Result.success("update yes");
    }

    @DeleteMapping
    public Result delete(int id){
        Category cs =  categoryService.detail(id);
        if(cs==null) return Result.error("不存在此类别");
        categoryService.delete(id);
        return Result.success("delete yes");
    }
}
