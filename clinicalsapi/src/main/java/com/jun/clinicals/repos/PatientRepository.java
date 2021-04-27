package com.jun.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
