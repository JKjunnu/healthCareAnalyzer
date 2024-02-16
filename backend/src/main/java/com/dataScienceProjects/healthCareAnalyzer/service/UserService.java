package com.dataScienceProjects.healthCareAnalyzer.service;

import com.dataScienceProjects.healthCareAnalyzer.dto.AuthResponse;
import com.dataScienceProjects.healthCareAnalyzer.entity.UserEntity;
import com.dataScienceProjects.healthCareAnalyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserEntity userEntity){

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles("ROLE_USER");
        userRepository.save(userEntity);

        return "User added successfully";
    }

    public AuthResponse findUserByEmail(String email){
        Optional<UserEntity> optionalUser= userRepository.findByEmail(email);
       if(optionalUser.isPresent()){
           UserEntity user = optionalUser.get();
           return new AuthResponse(user.getEmail(),user.getFirstName(),user.getLastName(), user.getRoles());
       }else{
           throw new UsernameNotFoundException("User not found with "+email);
       }

    }

    public String addAdmin(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles("ROLE_ADMIN");
        userRepository.save(userEntity);

        return "Admin added successfully";
    }
}
