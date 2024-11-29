package com.MedicalLabaratory.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labtests")
@CrossOrigin(origins = "http://localhost:3000")


public class LabTestController {
	
	 @Autowired
	    private LabTestRepository labTestRepository;

	    @Autowired
	    private LabTestResultRepository labTestResultRepository;

	    // 1. Create new lab test
	    @PostMapping("/order")
	    public LabTest orderLabTest(@RequestBody LabTest labTest) {
	        labTest.setStatus(LabTestStatus.PENDING);
	        return labTestRepository.save(labTest);
	    }

	    // 2. Update lab test status
	    @PutMapping("/{testId}/status")
	    public LabTest updateTestStatus(@PathVariable Long testId, @RequestParam LabTestStatus status) {
	        LabTest labTest = labTestRepository.findById(testId).orElseThrow(() -> new RuntimeException("Test not found"));
	        labTest.setStatus(status);
	        return labTestRepository.save(labTest);
	    }

	    // 3. Upload lab test result
	    @PostMapping("/{testId}/results")
	    public LabTestResult uploadTestResult(@PathVariable Long testId, @RequestBody LabTestResult result) {
	        result.setTestId(testId);
	        return labTestResultRepository.save(result);
	    }

	 // 4. Get test results by testId for doctors
	    @GetMapping("/{testId}/results")
	    public List<LabTestResult> getTestResults(@PathVariable("testId") Long testId) {
	        return labTestResultRepository.findByTestId(testId);
	    }


	 // 5. Get test results for patients by patientId
	    @GetMapping("/patients/{patientId}/myresults")
	    public List<LabTest> getTestResultsForPatient(@PathVariable Long patientId) {
	        return labTestRepository.findByPatientId(patientId);
	    }

	    @GetMapping("/all")
	    public List<LabTest> getAllLabTests() {
	        return labTestRepository.findAll();
	    }

	}