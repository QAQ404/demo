package com.example.demo.dao;

import com.example.demo.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void add(Category category);


    List<Category> list(int userid);

    Category detail(int caid);

    void update(Category category);

    void delete(int id);
}
