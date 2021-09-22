package com.alvarez.dojosandninjas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alvarez.dojosandninjas.models.LoginUser;
import com.alvarez.dojosandninjas.models.User;
import com.alvarez.dojosandninjas.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "user.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "user.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}
	
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	
        User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "user.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/";
    }	
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long loggedInUserId = (Long)session.getAttribute("user_id");
		if(loggedInUserId == null) {
			return "redirect:/user";
		}
		User loggedInUser = this.userService.findUser(loggedInUserId);
		
		model.addAttribute("loggedInUser",loggedInUser);
		return "temp.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/user";
	}
	
}
