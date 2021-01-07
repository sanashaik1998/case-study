package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.exception.ApplicationException;
import com.hcl.model.User;
import com.hcl.service.UserService;
import com.hcl.validation.SecurityService;
@Controller
@RequestMapping("user")
public class RegistrationController {
	
	@Autowired
	private SecurityService securityServiceImpl;
	
	@Autowired
	private UserService userServiceImpl;
    

	
	
	@RequestMapping("front")
	public String addUserFront(Model model)
	{
		System.out.println("hello world");
		model.addAttribute("userDetails",new User());
		return "userregn";
	}
	
	@PostMapping("add")
	public String addUser(@ModelAttribute("userDetails") User user,Model model)
	{
		try {
			securityServiceImpl.validateUser(user);	
			userServiceImpl.doesUserExists(user);
			userServiceImpl.addUser(user);
	
			return "registered";
			
		} catch (ApplicationException e) {
			model.addAttribute("error",e.getMessage());
			return "userregn";
		}
	}

}
