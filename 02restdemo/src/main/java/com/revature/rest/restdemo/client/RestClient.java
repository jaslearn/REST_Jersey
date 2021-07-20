package com.revature.rest.restdemo.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.rest.restdemo.Employee;

public class RestClient {
public static void main(String[] args) {
	String URI="http://localhost:8080/02restdemo/webapi";
	Client client = ClientBuilder.newClient();
	WebTarget target 
	  = client.target(URI);
	String response = target.path("myresource").
            request().
            accept(MediaType.TEXT_PLAIN).
            get(String.class);
           
	System.out.println("Response :::: "+ response);
	
	
	String jsonData =
            target.path("myresource").path("json").request().accept(MediaType.APPLICATION_JSON).get(String.class);
	
	System.out.println("JSON Data ::: "+jsonData);
	
	try {
		Employee  e=new ObjectMapper().readValue(jsonData, Employee.class);
		System.out.println(e);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
