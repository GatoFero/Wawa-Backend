package com.wawa.wawa.service.interfaces;

import com.wawa.wawa.entity.User;
import com.wawa.wawa.utiles.UpdateData;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    User getUserByName(String name);

    User saveUser(User user);

    Object updateUsername(UpdateData updateData);
}
