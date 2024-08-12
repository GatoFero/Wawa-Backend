package com.wawa.wawa.service.interfaces;

import com.wawa.wawa.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
    boolean progressExists(String username, int idCourse);

    void addUser(User user);
    User updateUser(User user);
    void deleteUser(int id);

    User updateUserEmail(String email, int id);
    User updateUserUsername(String username, int id);
    User updateUserPassword(String password, String newPassword, int id);

    void buyVip(int id);

    boolean existsUser(int id);
    boolean existsUserByEmail(String email);
    boolean existsUserByUsername(String username);
}
