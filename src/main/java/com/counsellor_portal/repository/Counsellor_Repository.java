package com.counsellor_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.counsellor_portal.entity.Counsellor;

public interface Counsellor_Repository extends JpaRepository<Counsellor, Integer> {
	public Counsellor findByEmailId(String emailId);

	public Counsellor findByEmailIdAndPassword(String emailId, String password);
}
