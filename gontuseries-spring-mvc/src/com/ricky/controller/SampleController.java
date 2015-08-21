package com.ricky.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	
	//Sample demo of how to get path variables
	//1. can retrieve one at a time or
	//2. using Map to automatically capture all - need '<mvc:annotation-driven/>' in config.

	@RequestMapping("/sample/{countryName}/{userName}")
	protected ModelAndView processSample(@PathVariable Map<String,String> pathVars){

		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		ModelAndView modelAndView = new ModelAndView("SamplePage"); //Request send to helloPage.jsp
		modelAndView.addObject("msg", "Hello "+name + "; you are from "+country);
		
		return modelAndView;
	}
	

	@RequestMapping("/sample2/{countryName}/{userName}")
	protected ModelAndView processWelcome(@PathVariable("countryName") String country,
			@PathVariable("userName") String name){

		ModelAndView modelAndView = new ModelAndView("SamplePage"); //Request send to helloPage.jsp
		modelAndView.addObject("msg", "Hello "+name + "; you are from "+country);
		
		return modelAndView;
	}

}
