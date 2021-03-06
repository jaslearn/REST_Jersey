package com.revature.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rest.Employee;

public class RestClient {
public static void main(String[] args) {
	String URI="http://localhost:8080/03restapp/webapi";
	
	Client client = ClientBuilder.newClient();
	WebTarget target  = client.target(URI);
	
	String response = target.path("my"). /// "http://localhost:8080/03restapp/webapi/my
            request().
            accept(MediaType.TEXT_PLAIN).
            get(String.class);
           
	System.out.println("Response :::: "+ response.toUpperCase());
	
	
	
	String jsonData=target.path("my").path("json").request().accept(MediaType.APPLICATION_JSON).get(String.class).toString();
	System.out.println("JSON Data :::::::: " +jsonData );
	
	
	/*
	 * Employee emp1=null; try { emp1 = new ObjectMapper().readValue(jsonData,
	 * Employee.class); } catch (JsonProcessingException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * System.out.println("Employee Object ::: "+emp1);
	 */
}
}
