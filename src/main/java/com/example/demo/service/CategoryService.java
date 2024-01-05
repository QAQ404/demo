package com.example.demo.service;

import com.example.demo.pojo.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();

    Category detail(int caid);

    void update(Category category);

    void delete(int id);
}
