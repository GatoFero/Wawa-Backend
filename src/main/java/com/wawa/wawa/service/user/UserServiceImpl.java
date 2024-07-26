package com.wawa.wawa.service.user;

import com.wawa.wawa.entity.User;
import com.wawa.wawa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getIdUser() != null) {
            User exist = getUser(user.getIdUser());
            exist.setUsername(user.getUsername());
            return userRepository.save(exist);
        }
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
