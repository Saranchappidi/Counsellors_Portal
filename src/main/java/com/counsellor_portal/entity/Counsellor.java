package com.counsellor_portal.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Counsellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int counsellor_Id;
	private String name;
	private String emailId;
	private Long phone_Number;
	private String password;

	@CreationTimestamp
	private LocalDate creation_Date;
	@UpdateTimestamp
	private LocalDate updation_Date;

	@OneToMany(mappedBy = "counsellor", cascade = CascadeType.ALL)
	private List<Enquiry> enquires;

	public int getCounsellor_Id() {
		return counsellor_Id;
	}

	public void setCounsellor_Id(int counsellor_Id) {
		this.counsellor_Id = counsellor_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(Long phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Enquiry> getEnquires() {
		return enquires;
	}

	public void setEnquires(List<Enquiry> enquires) {
		this.enquires = enquires;
	}

	public Counsellor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
