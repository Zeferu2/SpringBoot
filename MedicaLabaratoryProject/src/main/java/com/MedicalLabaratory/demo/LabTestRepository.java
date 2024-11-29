package com.MedicalLabaratory.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LabTestRepository extends JpaRepository<LabTest, Long> {
	
	 List<LabTestResult> findByTestId(Long testId);
	 List<LabTest> findByPatientId(Long patientId);


}