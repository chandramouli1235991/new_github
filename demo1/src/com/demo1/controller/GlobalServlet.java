package com.demo1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo1.entity.DemoUser;
import com.demo1.service.DemoService;
import com.demo1.service.DemoServiceInterface;


public class GlobalServlet extends HttpServlet {
	

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
			 String option=request.getParameter("ac");	
	 if(option.equals("register")) {
		 String name=request.getParameter("name");
		 String pass=request.getParameter("pass");
		 String email=request.getParameter("email");
		 String address=request.getParameter("address");
	 
		DemoUser du=new DemoUser();
	du.setName(name);
	du.setPassword(pass);
	du.setEmail(email);
	du.setAddress(address);
	
		DemoServiceInterface ds=DemoService.createObject();
		int i=ds.createProfile(du);
		if(i>0) {
			out.println("profile created");
		}
		else
		{
			out.println("could not create profile");
		}
		
		
		
		
	
	}

}
}
