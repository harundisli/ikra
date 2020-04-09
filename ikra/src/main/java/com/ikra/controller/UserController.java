package com.ikra.controller;

import com.ikra.model.User;
import com.ikra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/api/users/{user-name}")
    public ResponseEntity<User> user( @PathVariable(value = "user-name") String userName)
    {
            return ResponseEntity.ok(userService.getUserByUserName(userName));
    }

}
