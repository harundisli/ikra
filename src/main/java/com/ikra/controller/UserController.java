package com.ikra.controller;

import com.ikra.dto.UserDTO;
import com.ikra.model.User;
import com.ikra.service.AuthenticationService;
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

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping(path = "/api/users/{name}")
    public ResponseEntity<User> user( @PathVariable(value = "name") String name)
    {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping(path = "/api/public/user/create")
    public ResponseEntity<?> userCreate(@RequestBody @Valid final UserDTO newUser) throws Exception {
        userService.saveNewUser(newUser);
        return ResponseEntity.ok(authenticationService.authenticate(newUser));
    }
}
