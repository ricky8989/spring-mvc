package com.ricky.util;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//This is an interceptor class that will display a message on Sunday
//instead of handling any request
public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	//if this method return true, application will handle the request
	//if false, application will not handle the request
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1=Sun, 2=Mon, etc
		if(dayOfWeek ==1){ //Sunday
			response.getWriter().write("This website is not availabe on Sundays; please try other days!");
			return false;
		}
		return true;
	}

	// will be call after Spring executes the request handler method
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("DayOfWeekBasedAccessInterceptor.postHandle()  - "+request.getRequestURI().toString());
	}
	
	// will be call after response object is produced
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("DayOfWeekBasedAccessInterceptor.afterCompletion()  - "+request.getRequestURI().toString());
	}
 }
