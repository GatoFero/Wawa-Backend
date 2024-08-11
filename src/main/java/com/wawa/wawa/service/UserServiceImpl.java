package com.wawa.wawa.service;

import com.wawa.wawa.entity.User;
import com.wawa.wawa.repository.UserRepository;
import com.wawa.wawa.service.interfaces.UserService;
import com.wawa.wawa.utiles.UpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserByName(String name){
        return userRepository.findByUsername(name);
    }
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public Object updateUsername(UpdateData updateData){
        User existingUser = userRepository.findByUsername(updateData.getData());
        if (existingUser != null) {
            existingUser.setUsername(updateData.getNewData());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }
}
