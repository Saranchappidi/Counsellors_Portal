package com.counsellor_portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counsellor_portal.controller.Counsellor_Controller;
import com.counsellor_portal.entity.Counsellor;
import com.counsellor_portal.exceptions.EmailAlreadyExists;
import com.counsellor_portal.repository.Counsellor_Repository;

@Service
public class Counsellor_Service implements ICounsellor_Service {

	@Autowired
	private Counsellor_Repository counsellor_repo;

	private Logger logger = LoggerFactory.getLogger(Counsellor_Service.class);


	public boolean saveCounsellor(Counsellor counsellor)  {
		
	    Counsellor existingCounsellor = counsellor_repo.findByEmailId(counsellor.getEmailId());
	    if (existingCounsellor != null) {
	        logger.warn("Email already exists for Counsellor: {}", counsellor.getEmailId());
	        return false;
	    } 
		else {
	            Counsellor savedCounsellor = counsellor_repo.save(counsellor);
	            if (savedCounsellor != null) {
	                logger.info("Counsellor saved successfully: {}", counsellor.getEmailId());
	                return true;
	            } else {
	                logger.error("Failed to save Counsellor: {}", counsellor.getEmailId());
	                return false;
	            }
	 
	    }
	}

	@Override
	public Counsellor counsellor_Login(String emailId, String password) {
		Counsellor loginCounsellor= counsellor_repo.findByEmailIdAndPassword(emailId, password);
		if(loginCounsellor !=null) {
			logger.info("Login Successful" + emailId);
			return loginCounsellor;
		}
		else {
			logger.warn("Invalid details!"+emailId+"Password"+password);
		}
		return loginCounsellor;
	}

}
