package com.alvarez.dojosandninjas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alvarez.dojosandninjas.models.Dojo;
import com.alvarez.dojosandninjas.models.Ninja;
import com.alvarez.dojosandninjas.models.User;
import com.alvarez.dojosandninjas.services.AppService;
import com.alvarez.dojosandninjas.services.UserService;

@Controller
public class HomeController {

	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService = appService;
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home(Model model, @ModelAttribute("dojo") Dojo dojo, HttpSession session) {
		Long loggedInUserId = (Long)session.getAttribute("user_id");
		if(loggedInUserId == null) {
			return "redirect:/user";
		}
		User loggedInUser = this.userService.findUser(loggedInUserId);
		
		model.addAttribute("loggedInUser",loggedInUser);
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "home.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createNewDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "home.jsp";
		}
		else {
			this.appService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/new/ninja")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "ninja.jsp";
		}
		else {
			this.appService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojoDetails(@PathVariable("id")Long id, Model model) {
		
		Dojo d = this.appService.getOneDojo(id);
		model.addAttribute("dojo",d);
		return "details.jsp";
	}
}
