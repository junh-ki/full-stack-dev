package com.jun.clinicals.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jun.clinicals.model.ClinicalData;
import com.jun.clinicals.model.Patient;
import com.jun.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {

	private PatientRepository repository;
	
	@Autowired
	PatientController(PatientRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping(value="/patients", method=RequestMethod.GET)
	public List<Patient> getPatients() {
		return repository.findAll();
	}
	
	@RequestMapping(value="/patients/{id}", method=RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/patients", method=RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient) {
		return repository.save(patient);
	}
	
	@RequestMapping(value="/patients/analyze/{id}", method=RequestMethod.GET)
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = repository.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalData();
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		for(ClinicalData eachEntry : duplicateClinicalData) {
			
		}
		
		return patient;
	}

}
