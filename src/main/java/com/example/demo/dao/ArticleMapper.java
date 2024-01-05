package com.example.demo.dao;

import com.example.demo.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    void add(Article article);

    List<Article> list(String categoryId, String state, int id);
}
