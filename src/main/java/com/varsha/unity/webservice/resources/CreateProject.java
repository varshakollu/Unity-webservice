package com.varsha.unity.webservice.resources;

import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//Creating POST request API. This can be accessed using the @Path annotation value
@Path("/createProject")
public class CreateProject {
	
	String output ="Campaign is successfully created"; //Response to be displayed if status code 200 is received.
	ObjectMapper mapper = new ObjectMapper(); //Class provided by Jackson library to convert between java objects and JSON

	//This method is called when POST request is issued.
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //This annotation indicates that POST request can accept only JSON data.
    @Produces(MediaType.TEXT_PLAIN) //This annotation indicates that POST request produces plain text response to the client.
    public Response addProject(Project project) {

		/* 
	    Converts the java object to JSON using the inbuilt method writeValueAsString provided by the library.
	    writerWithDefaultPrettyPrinter() is used so that JSON values will not be stored in a compact manner. 
		Here the JSON values are appended to a text file named projects.txt which is in D drive. 
	    */
		
		try{
						
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(project); //Converts Java Object to JSON	
			FileWriter fw = new FileWriter("D:\\projects.txt",true); 
			fw.write(jsonInString); //Appends data to file
		    fw.append(System.lineSeparator()); //Creates a new line
		    fw.close(); //Closes the file
			
		   } catch (JsonGenerationException e) {
			   e.printStackTrace();
		   } catch (JsonMappingException e) {
			   e.printStackTrace();
		   } catch (IOException e) {
			   e.printStackTrace();
		 }
	
		return Response.status(200).entity(output).build(); //Returns success message if status code 200 is received.    
			
	 }
}
