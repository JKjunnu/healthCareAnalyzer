package com.dataScienceProjects.healthCareAnalyzer.controller;

import com.dataScienceProjects.healthCareAnalyzer.entity.UserEntity;
import com.dataScienceProjects.healthCareAnalyzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

    @Autowired
    private UserService userService;
    @PostMapping
    public String registerUser(@RequestBody UserEntity userEntity){
        return userService.addUser(userEntity);
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String registerAdmin(@RequestBody UserEntity userEntity){return userService.addAdmin(userEntity);}
}
