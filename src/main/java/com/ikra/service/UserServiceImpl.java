package com.ikra.service;

import com.ikra.dto.UserDTO;
import com.ikra.exception.UserAlreadyExistException;
import com.ikra.model.User;
import com.ikra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserByName(String name) {
        return  userRepository.findByName(name);

    }

    @Override
    public User saveNewUser(UserDTO newUser)  {
        if(emailExists(newUser.getEmail()))
        {
            throw new UserAlreadyExistException("There is an account with that email adress: " + newUser.getEmail());

        }
        final  User user = new User();
        user.setName(newUser.getName());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setEmail(newUser.getEmail());

        return userRepository.save(user);
    }
    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
