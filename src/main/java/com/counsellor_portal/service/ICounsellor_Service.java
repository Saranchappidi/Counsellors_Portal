package com.counsellor_portal.service;

import com.counsellor_portal.entity.Counsellor;

public interface ICounsellor_Service {
	
	public  boolean saveCounsellor(Counsellor counsellor);
	 public   Counsellor counsellor_Login(String emailId, String password);

}
