package com.counsellor_portal.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.counsellor_portal.entity.Enquiry;


public interface Enquiry_Repository extends JpaRepository<Enquiry, Integer>{
	
	
	@Query(value="select count(*) from enquiry where counsellor_Id =:counsellor_Id",nativeQuery =true)
	public Long getEnquries(Integer counsellor_Id);
	
	@Query(value="select count(*) from enquiry where counsellor_Id =:counsellor_Id and status =:status",nativeQuery = true)
	public Long getEnquiresByStatus(Integer counsellor_Id,String status);

}
