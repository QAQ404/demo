package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {

    void register(String username, String password);

    User findByUsername(String username);

    void update(User user);

    void updateAvatar(String avataUrl);

    void updatePwd(String newPwd);
}
