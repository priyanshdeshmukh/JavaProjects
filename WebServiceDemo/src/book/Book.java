package book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")      //URI
public class Book {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML(){
		
		String response = "<?xml version='1.0'?>" +
						"<hello>Hello XML</hello>";
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON(){
		
		String response = null;
		return response;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(){
		
		String response = "<h1>Hello HTML</h1>";
		return response;
	}
}
