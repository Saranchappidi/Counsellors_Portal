package com.counsellor_portal.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiry_Id;
	private String student_Name;
	private String mode;
	private Long student_PhoneNumber;
	private String course;
	private String status;
	
	@CreationTimestamp
	private LocalDate creation_Date;
	@UpdateTimestamp
	private LocalDate updation_Date;
	
	@ManyToOne
	@JoinColumn(name="counsellor_id")
	private Counsellor counsellor;
	
	
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getEnquiry_Id() {
		return enquiry_Id;
	}
	public void setEnquiry_Id(Integer enquiry_Id) {
		this.enquiry_Id = enquiry_Id;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Long getStudent_PhoneNumber() {
		return student_PhoneNumber;
	}
	public void setStudent_PhoneNumber(Long student_PhoneNumber) {
		this.student_PhoneNumber = student_PhoneNumber;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDate getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(LocalDate creation_Date) {
		this.creation_Date = creation_Date;
	}

	public LocalDate getUpdation_Date() {
		return updation_Date;
	}

	public void setUpdation_Date(LocalDate updation_Date) {
		this.updation_Date = updation_Date;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}
	
	
	

}
