package com.dataScienceProjects.healthCareAnalyzer.repository;

import com.dataScienceProjects.healthCareAnalyzer.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<PatientEntity, Integer> {

    List<PatientEntity> findByAgeBetween(int i, int i1);

    List<PatientEntity> findByCa(int ele);

    List<PatientEntity> findByCholBetween(int i, int i1);

    List<PatientEntity> findByOrderByIdAsc();

    List<PatientEntity> findByCp(int ele);

    List<PatientEntity> findByExang(int ele);

    List<PatientEntity> findByFbs(int ele);

    List<PatientEntity> findByOldpeakBetween(int i, int i1);

    List<PatientEntity> findByRestecg(int ele);

    List<PatientEntity> findBySex(int ele);

    List<PatientEntity> findBySlope(int ele);

    List<PatientEntity> findByTargetBetween(double v, double v1);

    List<PatientEntity> findByThal(int ele);

    List<PatientEntity> findByThalachBetween(int i, int i1);

    List<PatientEntity> findByTrestbpsBetween(int i, int i1);
}
