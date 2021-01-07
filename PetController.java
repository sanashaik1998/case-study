package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.exception.ApplicationException;
import com.hcl.model.Pet;
import com.hcl.model.User;
import com.hcl.service.PetService;
import com.hcl.service.UserService;
import com.hcl.validation.PetValidator;
@Controller
public class PetController {

	@Autowired
	private PetService petServiceImpl;

	@Autowired
	private PetValidator petValidatorImpl;

	@Autowired
	private UserService userServiceImpl;


	@RequestMapping("pets")
	public String petHome(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			List<Pet> petsList = petServiceImpl.getAllPets();
			
			if (petsList.size() > 0) {
			
				model.addAttribute("pets", petsList);
				return "pet_home";
			} else {
				model.addAttribute("message", "There are no pets to show");
				return "pet_home";
			}
		} else {
			return "redirect:user/login";
		}

	}

	@RequestMapping("petfront")
	public String addPetFront(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {

			model.addAttribute("petDetails", new Pet());
			return "pet_form";
		} else {
			return "redirect:user/login";
		}

	}

	@PostMapping("addPet")
	public String addPet(@ModelAttribute("petDetails") Pet petdetails, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			try {
				petValidatorImpl.validatePet(petdetails);
				petServiceImpl.savePet(petdetails);
	
				return "redirect:/pets";
			} catch (ApplicationException e) {
				model.addAttribute("error", e.getMessage());
				return "pet_form";
			}
		} else {
			return "redirect:user/login";
		}

	}

	@RequestMapping("buyPet/{petId}")
	public String buyPet(@PathVariable("petId") long petId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			userServiceImpl.buyPet(petId, user);
			return "redirect:/pets";
		} else {
			return "redirect:user/login";
		}
	}

	@RequestMapping("mypets")
	public String myPets(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			List<Pet> myPets = userServiceImpl.getMyPets(user);
	
			if (myPets.size() > 0) {
		
			return "redirect:user/login";
		}

		}
	}
}


