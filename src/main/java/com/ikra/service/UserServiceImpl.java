package com.ikra.service;

import com.ikra.model.User;
import com.ikra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        return  userRepository.findByUsername(userName);

    }

    @Override
    public User saveNewUser(User newUser) {
        return userRepository.save(newUser);
    }
}
