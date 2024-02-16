package com.dataScienceProjects.healthCareAnalyzer.controller;

import com.dataScienceProjects.healthCareAnalyzer.dto.AuthRequest;
import com.dataScienceProjects.healthCareAnalyzer.dto.AuthResponse;
import com.dataScienceProjects.healthCareAnalyzer.dto.Product;
import com.dataScienceProjects.healthCareAnalyzer.service.JwtService;
import com.dataScienceProjects.healthCareAnalyzer.service.ProductService;
import com.dataScienceProjects.healthCareAnalyzer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LoginController {

    @Autowired
    private ProductService productService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest
                .getEmail(),authRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            AuthResponse authResponse = new AuthResponse();
            String token = jwtService.generateToken(authRequest.getEmail());
            AuthResponse userDetails = userService.findUserByEmail(authRequest.getEmail());
            authResponse.setToken(token);
            authResponse.setEmail(userDetails.getEmail());
            authResponse.setFirstName(userDetails.getFirstName());
            authResponse.setLastName(userDetails.getLastName());
            authResponse.setRoles(userDetails.getRoles());
            return ResponseEntity.ok(authResponse);
        }else{
            throw new UsernameNotFoundException("invalid user request!");
        }

    }


}
