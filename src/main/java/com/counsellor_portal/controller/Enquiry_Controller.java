package com.counsellor_portal.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.counsellor_portal.entity.Enquiry;
import com.counsellor_portal.service.Enquiry_Service_Impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Enquiry_Controller {

	@Autowired
	private Enquiry_Service_Impl enquiry_service;

	// It is loading the enquiry page
	@GetMapping("/enquiry")
	public String loadAddEnquiry(Model model) {
		model.addAttribute("enquiry", new Enquiry());
		return "addEnquiryPage";
	}

	// Adding the enquiry
	@PostMapping("/enquiry")
	public String addEnquiry(Enquiry enquiry, Model model, HttpServletRequest servletRequest) {
		HttpSession sesson = servletRequest.getSession(false);
		Integer cid = (Integer) sesson.getAttribute("cid");
		boolean savedEnquiry = enquiry_service.addEnquiry(enquiry, cid);
		if (savedEnquiry == true) {
			model.addAttribute("smsg", "Enquiry Successfully Saved");
		} else {
			model.addAttribute("emsg", "failed to save enquiry");
		}
		model.addAttribute("enquiry", new Enquiry());
		// model.addAttribute("dashboard", new DashBoard());
		return "addEnquiryPage";

	}

	@GetMapping("/enquires")
	public String getAllEnquires(HttpServletRequest httpServletRequest, Model model) {
		HttpSession session = httpServletRequest.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");
		List<Enquiry> enquiryList = enquiry_service.getEnquries(cid, new Enquiry());
		model.addAttribute("AllEnquiryList", enquiryList);
		model.addAttribute("filters", new Enquiry());
		return "viewEnquires";

	}

	@PostMapping("/filter-enquiry")
	public String filterEnquires(@ModelAttribute("filters") Enquiry filters, HttpServletRequest httpServletRequest,
			Model model, Enquiry enquiry) {
		HttpSession session = httpServletRequest.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");
		List<Enquiry> filteredEnquires = enquiry_service.getEnquries(cid, filters);
		model.addAttribute("AllEnquiryList", filteredEnquires);
		return "viewEnquires";
	}

	@GetMapping("/edit-enquiry")
	public String editEnquiry(@ModelAttribute("enquiry") Enquiry enquiry,
			@RequestParam("enquiry_Id") Integer enquiry_Id, Model model, HttpServletRequest httpservletrequest) {
		HttpSession session = httpservletrequest.getSession(false);
		Enquiry enq = enquiry_service.getEnquiry(enquiry_Id);

		model.addAttribute("AllEnquiryList", enq);

		return "updateEnquiryPage";
	}

}
