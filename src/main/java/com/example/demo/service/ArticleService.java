package com.example.demo.service;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(int pageNum, int pageNum1, String categoryId, String state);

    Article detail(int id);

    void delete(int id);

    void update(Article article);
}
