package com.ricky.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ricky.model.Student;
import com.ricky.util.StudentNameEditor;

@Controller
public class StudentAdmissionController {

	//http://localhost:8081/gontuseries-spring-mvc/admissionForm.html
	@RequestMapping(value={"/admissionForm.html","/"}, method=RequestMethod.GET)
	public ModelAndView getAdmissionForm(){
		ModelAndView model = new ModelAndView("AdmissionForm");//this is the jsp file name
		//model.addObject("headerMessage", "Sample Template for Spring MVC");
		return model;
	}

	/**
	 * Sample use of spring ModelAttribute to automatically retrieve/bind form elements
	 */

	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("studentInfo") Student student,
			BindingResult result){
		
		if (result.hasErrors() ){
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		//model.addObject("headerMessage", "Sample Template for Spring MVC");
		return model;
	}
	
	/**
	 * Since 'headerMessage' is added in both method, it can be remove and add
	 * in a separate method.
	 * @param model
	 */
	@ModelAttribute
	public void addingCommonData(Model model){
		model.addAttribute("headerMessage", "Spring MVC");
	}
	
	/**
	 * Sample usage to prevent spring auto model binding for a specific
	 * form element. In this case 'studentMobile' 
	 */
	
	@InitBinder
	public void customizeBinding(WebDataBinder binder){
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		
		//specify format for studentDOB
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
//	
//	/**
//	 * Sample use of spring RequestParameter to retrieve all form elements
//	 */
//	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
//	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> params){
//		
//		String name = params.get("studentName");
//		String hobby = params.get("studentHobby");
//		Student student = new Student();
//		student.setStudentName(name);
//		student.setStudentHobby(hobby);
//		ModelAndView model = new ModelAndView("AdmissionSuccess"); //this is the jsp file name
//		model.addObject("headerInfo", "Form submitted successfully!");
//		model.addObject("studentInfo", student);
//		
//		return model;
//	}
//	/**
//	 * Sample use of spring RequestParameter to retrieve specific form elements
//	 */
//	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
//	public ModelAndView submitAdmissionForm(
//			@RequestParam(value="studentName", defaultValue="John Doe") String name,
//			@RequestParam("studentHobby") String hobby){
//		
//		ModelAndView model = new ModelAndView("AdmissionSuccess"); //this is the jsp file name
//		model.addObject("msg", "Detail submitted is Name ="+name+" and hobby = "+hobby+".");
//		
//		return model;
//	}
}
