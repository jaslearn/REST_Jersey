package com.revature.rest.emp.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rest.emp.dao.PersonDAO;
import com.revature.rest.emp.dao.PersonDAOImpl;
import com.revature.rest.emp.model.Person;

@Path("personapi")
public class PersonController {

	@GET
	@Path("/persons") // http://localhost:8080/emprest/webapi/personapi/persons
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersons() {
		ObjectMapper mapper = new ObjectMapper();
		PersonDAO personDao= new PersonDAOImpl();
		List<Person> pList=personDao.getPersons();
		try {
			return mapper.writeValueAsString(pList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@GET
	@Path("/persons/{id}") // http://localhost:8080/emprest/webapi/personapi/persons/3
	@Produces(MediaType.APPLICATION_JSON)
	public String getPerson(@PathParam("id") int num) {
		ObjectMapper mapper = new ObjectMapper();
		PersonDAO personDao= new PersonDAOImpl();
		Person p1=personDao.getPerson(num);
		try {
			return mapper.writeValueAsString(p1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	
	@POST
	@Path("/persons")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response addPerson(String request) {
		Person p =null;
		String result=null;
		PersonDAO personDao= new PersonDAOImpl();
		try {
			p=new ObjectMapper().readValue(request, Person.class);
			System.out.println(p);
			result=personDao.addPerson(p);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("/persons/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePerson(@PathParam ("id") int id) {
		// some code 
		
		return "";
	}
}
