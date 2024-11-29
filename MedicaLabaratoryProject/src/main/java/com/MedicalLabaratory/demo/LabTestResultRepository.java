package com.MedicalLabaratory.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




public interface LabTestResultRepository extends JpaRepository<LabTestResult, Long>{
	List<LabTestResult> findByTestIdIn(List<Long> collect);

	List<LabTestResult> findByTestId(Long testId);
}