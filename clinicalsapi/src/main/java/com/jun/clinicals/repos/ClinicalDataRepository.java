package com.jun.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
