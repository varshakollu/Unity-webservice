package com.varsha.unity.webservice.resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


//Creating POST request API. This can be accessed using the @Path annotation value
@Path("/requestProject") 
public class RequestProject {
	
	Date today = new Date(); //To get current date.
	ResponseProject response = new ResponseProject(); 
	ObjectMapper mapper = new ObjectMapper(); //Class provided by Jackson library to convert between java objects and JSON
	
	 	
	@SuppressWarnings({ "unused" })
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseProject getProject(@QueryParam("projectid") int getpid, @QueryParam("country") String getcountry, 
    		@QueryParam("number") int getnumber, @QueryParam("keyword") String getkeyword) throws FileNotFoundException, IOException {
  
	   //Converting JSON to Java object.
	   Project[] data1 = new Gson().fromJson(new FileReader("D:\\projects.txt"), Project[].class);
	   List<Project> projectList = Arrays.asList(data1); 
	   	   
	   double maxcost2=0.0;
	   boolean flag=false;
	   
	   /*Code to be executed when no parameters are passed.*/ 
	   if(getpid==0 && getcountry==null && getnumber ==0.0 && getkeyword==null){
		   for(Project project:projectList)
		   {
			 if(project.getProjectCost()>maxcost2)
				 {
				  maxcost2=project.getProjectCost();

				 }
			}			  
		  for(Project project : projectList){
			  
			  Date expiryDate = RequestProject.changeDate(project.getExpiryDate());
			  if(maxcost2==project.getProjectCost() && project.isEnabled()==true && today.before(expiryDate) && project.getProjectUrl()!=null){
				  response.setProjectName(project.getProjectName());
				  response.setProjectCost(project.getProjectCost());
				  response.setProjectUrl(project.getProjectUrl());
				  flag=true;
			  }
		  }
		  if(flag==false)
			   response.setMessage("No project found");
		  
		  return response;
		}
	   
	   /*Code to be executed when only project id parameter is passed.*/
	   else if(getpid!=0)
	   {
		   flag=false;
		   for(Project project : projectList){
				  
				  if(getpid==project.getId())
				  {
					  response.setProjectName(project.getProjectName());
					  response.setProjectCost(project.getProjectCost());
					  response.setProjectUrl(project.getProjectUrl());
					  flag=true;		  
				  }				 
			  }
		   
		   if(flag==false)
			   response.setMessage("No project found");
		  		   
		   return response;
	   }
	
	   
	   /*Checking if country is not null. If so, checking if any other parameters are passed.*/ 
	   else if(getcountry!=null)
	   {
		   ArrayList<Project> countriesList= new ArrayList<Project>();
		   ArrayList<Project> keywordCountryList= new ArrayList<Project>();
		   ArrayList<Project> tempList= new ArrayList<Project>();
		   ArrayList<Project> numberKeywordCountryList= new ArrayList<Project>();

		   ArrayList<Project> finalList= new ArrayList<Project>();
		   flag=false;
		   double maxcost1=0.0; 
		   Project p=null;
		   for(Project project : projectList){
				  
				  Date expiryDate = RequestProject.changeDate(project.getExpiryDate());
				  for(String targetCountries:project.getTargetCountries())
				  {
					  if(getcountry.equalsIgnoreCase(targetCountries) && project.isEnabled()==true && today.before(expiryDate) && project.getProjectUrl()!=null)
						{
						  countriesList.add(project);
						  flag=true;
						}
				  }
		   }
		   
		   if(flag==false)
		   {
			   response.setMessage("No project found");  
			   return response;
		   }
		   
		   else{
			   if(getkeyword!=null)
			   {
				   for(Project project : countriesList)
				   {
					     for(TargetKeys keyword:project.getTargetKeys())
						  {					  
							  if(getkeyword.equalsIgnoreCase(keyword.getKeyword()))
								{
								  keywordCountryList.add(project);
								}
						  }
				   }
			   	}
			   if(getnumber!=0)
			   {
				   
				   tempList=(keywordCountryList.size()!=0)?keywordCountryList:countriesList;
				   for(Project project:tempList) 
					{
					   for(TargetKeys number:project.getTargetKeys())
						  {					  
							  if(getnumber<=number.getNumber())
								{
								  numberKeywordCountryList.add(project);
								}
						  } 
					 }
				 }
			  }
		   
		   if(keywordCountryList.isEmpty() && numberKeywordCountryList.isEmpty()){
			   finalList=countriesList;
		   }
		   else if(keywordCountryList.isEmpty() ){
			   finalList=numberKeywordCountryList;
		   }
		   else if(numberKeywordCountryList.isEmpty()){
			   finalList=keywordCountryList;
		   }
		   else
			   finalList=numberKeywordCountryList;
		   
		   for(Project project:finalList)
		   {
			 if(project.getProjectCost()>maxcost1)
				 {
				  maxcost1=project.getProjectCost();
				  p=project;
				 }
			}
		   
		      response.setProjectName(p.getProjectName());
			  response.setProjectCost(p.getProjectCost());
			  response.setProjectUrl(p.getProjectUrl());
			 
	  return response;	   
		   
		}
	   
	   
	   /*Checking if keyword is not null. If so, checking if any other parameters are passed.*/ 
	   else if(getkeyword!=null)
	   {
		   ArrayList<Project> keywordList= new ArrayList<Project>();
		   ArrayList<Project> countryKeywordList= new ArrayList<Project>();
		   ArrayList<Project> tempList= new ArrayList<Project>();
		   ArrayList<Project> numberCountryKeywordList= new ArrayList<Project>();

		   ArrayList<Project> finalList= new ArrayList<Project>();
		   flag=false;
		   double maxcost1=0.0; 
		   Project p=null;
		   for(Project project : projectList){
				  
				  Date expiryDate = RequestProject.changeDate(project.getExpiryDate());
				  for(TargetKeys targetKey:project.getTargetKeys())
				  {
					  if(getkeyword.equalsIgnoreCase(targetKey.getKeyword()) && project.isEnabled()==true && today.before(expiryDate) && project.getProjectUrl()!=null)
						{
						  keywordList.add(project);
						  flag=true;
						}
				  }
		   }
		   
		   if(flag==false)
		   {
			   response.setMessage("No project found");
			   return response;
		   }
		   
		   else{
			   if(getcountry!=null)
			   {
				   for(Project project : keywordList)
				   {
					   List<String> countryList = Arrays.asList(project.getTargetCountries());
					     for(String country:countryList)
						  {					  
							  if(getcountry.equalsIgnoreCase(country))
								{
								  countryKeywordList.add(project);
								}
						  }
				   }
			   	}
			   if(getnumber!=0)
			   {
				   
				   tempList=(countryKeywordList.size()!=0)?countryKeywordList:keywordList;
				   for(Project project:tempList) 
					{
					   for(TargetKeys number:project.getTargetKeys())
						  {					  
							  if(getnumber<=number.getNumber())
								{
								  numberCountryKeywordList.add(project);
								}
						  } 
					 }
				 }
			  }
		   
		   if(countryKeywordList.isEmpty() && numberCountryKeywordList.isEmpty()){
			   finalList=keywordList;
		   }
		   else if(countryKeywordList.isEmpty() ){
			   finalList=numberCountryKeywordList;
		   }
		   else if(numberCountryKeywordList.isEmpty()){
			   finalList=countryKeywordList;
		   }
		   else
			   finalList=numberCountryKeywordList;
		   
		   for(Project project:finalList)
		   {
			 if(project.getProjectCost()>maxcost1)
				 {
				  maxcost1=project.getProjectCost();
				  p=project;
				 }
			}
		   
		      response.setProjectName(p.getProjectName());
			  response.setProjectCost(p.getProjectCost());
			  response.setProjectUrl(p.getProjectUrl());
			 
	  return response;	   
		   
		}
  
	   /*Checking if number is not null. If so, checking if any other parameters are passed.*/ 
	   else if(getnumber!=0)
	   {
		   ArrayList<Project> numberList= new ArrayList<Project>();
		   ArrayList<Project> countryNumberList= new ArrayList<Project>();
		   ArrayList<Project> tempList= new ArrayList<Project>();
		   ArrayList<Project> keywordCountryNumberList= new ArrayList<Project>();

		   ArrayList<Project> finalList= new ArrayList<Project>();
		   flag=false;
		   double maxcost1=0.0; 
		   Project p=null;
		   for(Project project : projectList){
				  
				  Date expiryDate = RequestProject.changeDate(project.getExpiryDate());
				  for(TargetKeys targetKey:project.getTargetKeys())
				  {
					  if(getnumber==targetKey.getNumber() && project.isEnabled()==true && today.before(expiryDate) && project.getProjectUrl()!=null)
						{
						  numberList.add(project);
						  flag=true;
						}
				  }
		   }
		   
		   if(flag==false)
		   {
			   response.setMessage("No project found");
			   return response;
		   }
		   
		   else{
			   if(getcountry!=null)
			   {
				   for(Project project : numberList)
				   {
					   List<String> countryList = Arrays.asList(project.getTargetCountries());
					     for(String country:countryList)
						  {					  
							  if(getcountry.equalsIgnoreCase(country))
								{
								  countryNumberList.add(project);
								}
						  }
				   }
			   	}
			     
			   if(getkeyword!=null)
			   {
				   tempList=(countryNumberList.size()!=0)?countryNumberList:numberList;
				   for(Project project:tempList) 
					{
					   for(TargetKeys keyword : project.getTargetKeys())
						  {					  
							  if(getkeyword.equalsIgnoreCase(keyword.getKeyword()))
								{
								  keywordCountryNumberList.add(project);
								}
						  } 
					 }
				 }
			  }
		   
		   if(countryNumberList.isEmpty() && keywordCountryNumberList.isEmpty()){
			   finalList=numberList;
		   }
		   else if(countryNumberList.isEmpty() ){
			   finalList=keywordCountryNumberList;
		   }
		   else if(keywordCountryNumberList.isEmpty()){
			   finalList=countryNumberList;
		   }
		   else
			   finalList=keywordCountryNumberList;
		   
		   for(Project project:finalList)
		   {
			 if(project.getProjectCost()>maxcost1)
				 {
				  maxcost1=project.getProjectCost();
				  p=project;
				 }
			}
		   
		      response.setProjectName(p.getProjectName());
			  response.setProjectCost(p.getProjectCost());
			  response.setProjectUrl(p.getProjectUrl());
			 
	  return response;	   
	}
	
	   return response;   	  
			   
	}	   
		
		public static Date changeDate(String expdate){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS.SSS");
			Date finalDate = null;
			try {
				finalDate = df.parse(expdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return finalDate;
			
		}
	} 
	 