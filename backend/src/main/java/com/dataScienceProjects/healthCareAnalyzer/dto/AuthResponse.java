package com.dataScienceProjects.healthCareAnalyzer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String email;
    private String firstName;
    private String lastName;
    private String roles;
    private String token;

    public AuthResponse(String email, String firstName, String lastName, String roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }
}
