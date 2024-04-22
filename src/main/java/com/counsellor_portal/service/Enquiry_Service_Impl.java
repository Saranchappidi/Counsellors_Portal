package com.counsellor_portal.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.counsellor_portal.dto.DashBoard;
import com.counsellor_portal.entity.Counsellor;
import com.counsellor_portal.entity.Enquiry;
import com.counsellor_portal.repository.Counsellor_Repository;
import com.counsellor_portal.repository.Enquiry_Repository;

@Service
public class Enquiry_Service_Impl implements IEnquiry_Service {

	@Autowired
	private Enquiry_Repository enquiry_repo;

	@Autowired
	private Counsellor_Repository counsellor_Repo;

	private Logger logger = LoggerFactory.getLogger(Enquiry_Service_Impl.class);

	@Override
	public boolean addEnquiry(Enquiry enquiry, Integer counsellor_Id) {
		Counsellor counsellor = counsellor_Repo.findById(counsellor_Id).orElse(null);
		if (counsellor != null) {
			enquiry.setCounsellor(counsellor);
			boolean savedEnquiry = enquiry_repo.save(enquiry) != null;
			if (savedEnquiry) {
				logger.info("Enquiry Successfully saved");
			} else {
				logger.info("Enquiry is not saved");
			}
			return savedEnquiry;
		} else {
			logger.warn("Failed to save");
			return false;
		}
	}

	@Override
	public DashBoard dashBoard(Integer counsellor_Id) {
		Long totalEnquries = enquiry_repo.getEnquries(counsellor_Id);
		Long openEnquries = enquiry_repo.getEnquiresByStatus(counsellor_Id, "new");
		Long enrolledEnquries = enquiry_repo.getEnquiresByStatus(counsellor_Id, "enrolled");
		Long lostEnquries = enquiry_repo.getEnquiresByStatus(counsellor_Id, "lost");
		DashBoard d = new DashBoard();
		d.setTotal_enquries(totalEnquries);
		d.setOpen_Enquries(openEnquries);
		d.setEnrolled_enquries(enrolledEnquries);
		d.setLost_enquires(lostEnquries);
		logger.info("DashBoard Page Successfully Loading");
		return d;
	}

	@Override
	public List<Enquiry> getEnquries(Integer counsellor_Id, Enquiry enquiry) {
		// Counsellor counsellor =
		// counsellor_Repo.findById(counsellor_Id).orElseThrow();
		Counsellor counsellor = new Counsellor();
		counsellor.setCounsellor_Id(counsellor_Id);
		enquiry.setCounsellor(counsellor);

		// Adding filter values to entity
		Enquiry enquirySearch = new Enquiry();
		enquirySearch.setCounsellor(counsellor);

		if (null != enquiry.getCourse() && !"".equals(enquiry.getCourse())) {
			enquirySearch.setCourse(enquiry.getCourse());
		}
		if (null != enquiry.getMode() && !"".equals(enquiry.getMode())) {
			enquirySearch.setMode(enquiry.getMode());
		}
		if (null != enquiry.getStatus() && !"".equals(enquiry.getStatus())) {
			enquirySearch.setStatus(enquiry.getStatus());
		}

		// Dynamic query creation based on data given in the object
		Example<Enquiry> of = Example.of(enquirySearch);
		return enquiry_repo.findAll(of);
	}

	@Override
	public Enquiry getEnquiry(Integer enquiry_Id) {		
		Enquiry e= enquiry_repo.findById(enquiry_Id).orElseThrow();
		return e;
	}


}
