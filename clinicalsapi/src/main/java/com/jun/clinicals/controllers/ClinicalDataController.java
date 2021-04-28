package com.jun.clinicals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jun.clinicals.dto.ClinicalDataRequest;
import com.jun.clinicals.model.ClinicalData;
import com.jun.clinicals.model.Patient;
import com.jun.clinicals.repos.ClinicalDataRepository;
import com.jun.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {
	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;
	
	@Autowired
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}
	
	@RequestMapping(value="/clinicals",method=RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
	}

}
