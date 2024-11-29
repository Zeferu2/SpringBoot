package com.MedicalLabaratory.demo;

import java.sql.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lab_tests")
@Data
@NoArgsConstructor
public class LabTest {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long testId;
	  private Long patientId;
	  private Long doctorId;
	  private String testType;
	  @Enumerated(EnumType.STRING)
	  private LabTestStatus status;
	  private Date orderDate;
	  // Getters and Setters
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public LabTestStatus getStatus() {
		return status;
	}
	public void setStatus(LabTestStatus status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}

