package com.github.fabio2g.stocksync.controller;

import com.github.fabio2g.stocksync.dto.UserDTO;
import com.github.fabio2g.stocksync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity save(@RequestBody UserDTO user) {
        UserDTO newUser = userService.save(user);

        return ResponseEntity.ok().body(newUser);
    }
}
