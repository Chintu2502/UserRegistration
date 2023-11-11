package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.service.UserService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	@GetMapping("/register")
	  public String register(@ModelAttribute("user") UserDto userDto){
	      return "index";
	  }
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") UserDto userDto, Model model)
	{
		userservice.UserRegistration(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return  "login";
	}
	@GetMapping("/loginCheck")
	public String login() {
		return "login";
	}
	@PostMapping("loginCheck")
	public String validateUser(HttpServletRequest request,Model model)
	{
		User user= userservice.ValidateUser(request.getParameter("email"), request.getParameter("password"));
		
		if(user!=null) {
			model.addAttribute("message", user);
			return "user";
		}else
		{
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
}
