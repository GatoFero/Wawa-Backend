package com.wawa.wawa.service;

import com.wawa.wawa.entity.Progress;
import com.wawa.wawa.entity.User;
import com.wawa.wawa.repository.UserRepository;
import com.wawa.wawa.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return getUserByEmail(username);
    }

    @Override
    public boolean progressExists(String username, int idCourse) {
        User user = getUserByUsername(username);
        for (Progress progress : user.getProgress()) {
            if(progress.getCourse().getId() == idCourse) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    @Override
    public User updateUserEmail(String email, int id) {
        User user = userRepository.getReferenceById(id);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User updateUserUsername(String username, int id) {
        User user = userRepository.getReferenceById(id);
        user.setUsername(username);
        return userRepository.save(user);
    }

    @Override
    public User updateUserPassword(String password, String newPassword, int id) {
        User user = userRepository.getReferenceById(id);
        if(user.getPassword().equals(password)) {
            user.setPassword(newPassword);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void buyVip(int id) {
        userRepository.getReferenceById(id).setVip(true);
    }

    @Override
    public boolean existsUser(int id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
