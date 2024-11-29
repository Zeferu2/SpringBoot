package com.MedicalLabaratory.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {
	@Autowired
	  private LabTestService labTestService;
	  
	  @GetMapping("/{patientId}/labtests/results")
	  public List<LabTestResult> getPatientResults(@PathVariable Long patientId) {
	    return labTestService.getPatientResults(patientId);
	  }
	  
	  @GetMapping("/{patientId}/labtests/myresults")
	  public List<LabTestResult> getMyResults(@PathVariable Long patientId) {
	    return labTestService.getMyResults(patientId);
	  }
}
