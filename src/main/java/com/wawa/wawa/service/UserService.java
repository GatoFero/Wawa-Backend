package com.wawa.wawa.service;

import com.wawa.wawa.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user);
    User getUser(Integer id);
    void deleteUser(Integer id);
    List<User> getAllUsers();
}
