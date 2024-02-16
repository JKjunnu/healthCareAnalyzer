package com.dataScienceProjects.healthCareAnalyzer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients_tbl")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    String lastName;
    String email;
    Integer age;
    Integer sex;
    Integer cp;
    Integer trestbps;
    Integer chol;
    Integer fbs;
    Integer restecg;
    Integer thalach;
    Integer exang;
    Double oldpeak;
    Integer slope;
    Integer ca;
    Integer thal;
    Double target;
}
