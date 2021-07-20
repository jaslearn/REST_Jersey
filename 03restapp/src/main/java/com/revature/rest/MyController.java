package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/my")
public class MyController {
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHi() {
		return "Hiiii from My Controller";
	}

	
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJson() {
		
		Employee emp=new Employee(1,"Abhishek");
		Employee emp2=new Employee(2,"SreeKamal");
		
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(emp);
		empList.add(emp2);
		
		ObjectMapper obj=new ObjectMapper();
		
		try {
			return obj.writeValueAsString(empList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
}
