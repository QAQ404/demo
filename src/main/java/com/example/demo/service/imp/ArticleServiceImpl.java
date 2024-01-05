package com.example.demo.service.imp;

import com.example.demo.dao.ArticleMapper;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.PageBean;
import com.example.demo.service.ArticleService;
import com.example.demo.untils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        article.setCreateUser(id);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(int pageNum, int pageSize, String categoryId, String state) {
        //创建pagebean对象
        PageBean<Article> pageBean = new PageBean<>();
        //开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        List<Article> as = articleMapper.list(categoryId,state,id);
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Article> p = (Page<Article>) as;
        //把数据填充到PageBean对象中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());

        return pageBean;
    }
}
