package com.counsellor_portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.counsellor_portal.dto.DashBoard;
import com.counsellor_portal.entity.Counsellor;

import com.counsellor_portal.service.Counsellor_Service;
import com.counsellor_portal.service.Enquiry_Service_Impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Counsellor_Controller {

	@Autowired
	private Counsellor_Service counsellor_service;

	@Autowired
	private Enquiry_Service_Impl enquiry_service;

	private Logger logger = LoggerFactory.getLogger(Counsellor_Controller.class);

	@GetMapping("/")
	public String loadLoginPage(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "index";

	}

	@PostMapping("/login")
	public String handleLoginForm(Counsellor counsellor, Model model, HttpServletRequest httpRequest) {
		Counsellor c = counsellor_service.counsellor_Login(counsellor.getEmailId(), counsellor.getPassword());
		if (c == null) {
			model.addAttribute("emsg", "Invalid Credentials");
			model.addAttribute("counsellor", new Counsellor());
			return "index";
		} else {
			HttpSession session = httpRequest.getSession(true);
			session.setAttribute("cid", c.getCounsellor_Id());
			DashBoard dashBoardInfo = enquiry_service.dashBoard(c.getCounsellor_Id());
			model.addAttribute("dashboard", dashBoardInfo);
			model.addAttribute("counsellor", c);
			return "dashboard";
			// return "redirect:dashbaord";

		}

	}

	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerView";
	}

	@PostMapping("/register")
	public String handleRegister(Counsellor counsellor, Model model) {

		boolean status = counsellor_service.saveCounsellor(counsellor);
		if (status) {
			model.addAttribute("smsg", "Counsellor Successfully registered");
			model.addAttribute("counsellor", new Counsellor());
			return "index";
		} else {
			model.addAttribute("emsg", "Counsellor registration Failed!, Email Already Exists");
			model.addAttribute("counsellor", new Counsellor());
			return "index";
		}

	}

	@GetMapping("/logout")
	public String logOut(HttpServletRequest servletRequest, Model model) {
		HttpSession session = servletRequest.getSession(false);
		if (session != null) {
			session.invalidate();
			logger.info("Logged Out Successfully");
		} else {
			logger.info("Failed to logOut");
		}
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String viewDashBoard(HttpServletRequest httpServletRequest, Model model) {
		HttpSession session = httpServletRequest.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");

		DashBoard dashBoardInfo = enquiry_service.dashBoard(cid);

		model.addAttribute("dashboard", dashBoardInfo);
		return "dashboard";

	}

}
