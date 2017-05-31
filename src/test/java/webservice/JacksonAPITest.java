package webservice;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varsha.unity.webservice.resources.Project;

//Test to check if the conversion from Java Object to JSON is done correctly
public class JacksonAPITest {
	
	@Test
	public void testJackson() throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		Project project= objectMapper.readValue(new File(System.getProperty("user.dir")+"//TestData//JSONSample.json"), Project.class);
		
		assert project.getProjectName().equals("test project"):"Project Name is wrong";
		
	}
}
