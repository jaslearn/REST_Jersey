package com.revature.rest.emp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("my")
public class MyController {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Controlle";
	}
}
