package com.revature.rest.jersey;




import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Path("controller")
public class MyController {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello From Controller";
	}
	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHelloParam(@PathParam("name") String  myname) {
		return "Hello From Controller " + (myname);
	}
	
	@POST
	@Path("/form")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String PostForm(@FormParam("accept") String accept) {
		return "Accept was " + accept + ".";
	}
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetJson() {
		ObjectMapper mapper = new ObjectMapper();
		MyClass my = new MyClass();
		try {
			return mapper.writeValueAsString(my);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
