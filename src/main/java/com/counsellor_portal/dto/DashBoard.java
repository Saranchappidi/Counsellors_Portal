package com.counsellor_portal.dto;

public class DashBoard {
	
	private long total_enquries;
	private long open_Enquries;
	private long enrolled_enquries;
	private long lost_enquires;
	
	
	
	public long getTotal_enquries() {
		return total_enquries;
	}
	public void setTotal_enquries(long total_enquries) {
		this.total_enquries = total_enquries;
	}
	public long getOpen_Enquries() {
		return open_Enquries;
	}
	public void setOpen_Enquries(long open_Enquries) {
		this.open_Enquries = open_Enquries;
	}
	public long getEnrolled_enquries() {
		return enrolled_enquries;
	}
	public void setEnrolled_enquries(long enrolled_enquries) {
		this.enrolled_enquries = enrolled_enquries;
	}
	public long getLost_enquires() {
		return lost_enquires;
	}
	public void setLost_enquires(long lost_enquires) {
		this.lost_enquires = lost_enquires;
	}
	public DashBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DashBoard(long total_enquries, long open_Enquries, long enrolled_enquries, long lost_enquires) {
		super();
		this.total_enquries = total_enquries;
		this.open_Enquries = open_Enquries;
		this.enrolled_enquries = enrolled_enquries;
		this.lost_enquires = lost_enquires;
	}
	
	
	
	
	
	

}
