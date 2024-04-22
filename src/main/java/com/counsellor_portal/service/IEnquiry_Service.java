package com.counsellor_portal.service;

import java.util.List;

import com.counsellor_portal.dto.DashBoard;
import com.counsellor_portal.entity.Enquiry;

public interface IEnquiry_Service {
	
	public boolean addEnquiry(Enquiry enquiry,Integer counsellor_Id);
	public DashBoard dashBoard(Integer counsellor_Id);
	public List<Enquiry> getEnquries(Integer counsellor_Id,Enquiry enquiry);
	public Enquiry getEnquiry(Integer enquiry_Id);

}
