package com.ikra.controller;

import com.ikra.model.User;
import com.ikra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/api/user/create")
    public ResponseEntity<User> userCreate(@RequestBody User newUser)
    {
        return ResponseEntity.ok(userService.saveNewUser(newUser));
    }
}
