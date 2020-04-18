package com.ikra.service;

import com.ikra.dto.UserDTO;
import com.ikra.exception.UserAlreadyExistException;
import com.ikra.model.User;

public interface UserService {
    User getUserByName(String userName) ;
    User saveNewUser(UserDTO newUser) throws UserAlreadyExistException;
}
