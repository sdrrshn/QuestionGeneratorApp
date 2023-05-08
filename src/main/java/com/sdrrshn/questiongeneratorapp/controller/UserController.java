package com.sdrrshn.questiongeneratorapp.controller;

import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("${project.server.port}/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody UserAdd userAdd) {
        return ResponseEntity.ok(userService.add(userAdd));
    }




}
