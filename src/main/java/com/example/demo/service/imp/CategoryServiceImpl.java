package com.example.demo.service.imp;

import com.example.demo.dao.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.untils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        int userid = (int) map.get("id");
        category.setCreateUser(userid);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        int userid = (int) map.get("id");
        return categoryMapper.list(userid);
    }

    @Override
    public Category detail(int caid) {
        return categoryMapper.detail(caid);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }
}
