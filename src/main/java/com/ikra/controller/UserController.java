package com.ikra.controller;

import com.ikra.dto.UserDTO;
import com.ikra.model.User;
import com.ikra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/api/users/{name}")
    public ResponseEntity<User> user( @PathVariable(value = "name") String name)
    {
            return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping(path = "/api/public/user/create")
    public ResponseEntity<User> userCreate(@RequestBody @Valid final UserDTO newUser)
    {
        return ResponseEntity.ok(userService.saveNewUser(newUser));
    }
}
