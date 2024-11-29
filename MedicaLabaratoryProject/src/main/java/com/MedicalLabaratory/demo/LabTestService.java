package com.MedicalLabaratory.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class LabTestService {
	 @Autowired
	  private LabTestRepository labTestRepository;
	  
	  @Autowired
	  private LabTestResultRepository labTestResultRepository;
	  
	  public LabTest orderTest(LabTest labTest) {
	    return labTestRepository.save(labTest);
	  }
	  
	  public LabTest updateStatus(Long testId, LabTestStatus status) {
	    LabTest labTest = labTestRepository.findById(testId).orElseThrow();
	    labTest.setStatus(status);
	    return labTestRepository.save(labTest);
	  }
	  
	  public LabTestResult uploadResult(Long testId, LabTestResult labTestResult) {
	    LabTest labTest = labTestRepository.findById(testId).orElseThrow();
	    labTestResult.setTestId(testId);
	    return labTestResultRepository.save(labTestResult);
	  }
	  public List<LabTestResult> getPatientResults(Long patientId) {
		    return labTestResultRepository.findByTestIdIn(
		      labTestRepository.findByPatientId(patientId).stream().map(LabTest::getTestId).collect(Collectors.toList())
		    );
		  }
		  
		  public List<LabTestResult> getMyResults(Long patientId) {
		    // Add authentication check to ensure only patient can access their results
		    return getPatientResults(patientId);
		  }

}
