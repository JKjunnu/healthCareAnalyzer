package com.dataScienceProjects.healthCareAnalyzer.controller;

import com.dataScienceProjects.healthCareAnalyzer.dto.AnalyticsColumn;
import com.dataScienceProjects.healthCareAnalyzer.dto.ArrayOfObjects;
import com.dataScienceProjects.healthCareAnalyzer.entity.PatientEntity;
import com.dataScienceProjects.healthCareAnalyzer.service.AnalyticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/analytics")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AnalyticsController {
    @Autowired
    private AnalyticsService analyticsService;
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<ArrayOfObjects> getAnalyticsData(@RequestBody AnalyticsColumn analyticsColumn){

        ArrayOfObjects analyticsData = analyticsService.getAnalyticsData(analyticsColumn.getColumnName());

        return ResponseEntity.ok(analyticsData);

    }

    @GetMapping("/patients")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public List<PatientEntity> getAllPatients(){
        return analyticsService.getAllPatients();
    }

    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String uploadCsv(@RequestParam("file") MultipartFile file) throws Exception{
        if(file.isEmpty()){
            throw new UsernameNotFoundException("File not found!");
        }else{
            return analyticsService.uploadCsv(file);
        }

    }
}
