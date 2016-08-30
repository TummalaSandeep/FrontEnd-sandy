 package com.niit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.DAO.UserDetailsDAO;
import com.niit.ShoppingCart.model.UserDetails;

@Controller
public class HomeController 
{
	@Autowired
	UserDetailsDAO ud;
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView m1=new ModelAndView("Home");
		return m1;
	}
	
	@RequestMapping("/reg")
	public ModelAndView regi()
	{
		ModelAndView m1=new ModelAndView("register");
		return m1;
	}
	@ModelAttribute("UserDetails")
	public UserDetails registerUser() {
		return new UserDetails();

	}
	@RequestMapping(value = "storeUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails userdetails,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Errors");
			return "register";
		}
		System.out.println(userdetails.getUsername());
		ud.save(userdetails);
		return "register";
	}

	 
}