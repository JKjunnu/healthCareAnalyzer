package com.dataScienceProjects.healthCareAnalyzer.service;

import com.dataScienceProjects.healthCareAnalyzer.config.UserInfoUserDetails;
import com.dataScienceProjects.healthCareAnalyzer.entity.UserEntity;
import com.dataScienceProjects.healthCareAnalyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);

        return optionalUser.map(UserInfoUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("user not found"+email));

    }
}
