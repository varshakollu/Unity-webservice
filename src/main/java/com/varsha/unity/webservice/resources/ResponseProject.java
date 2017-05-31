package com.varsha.unity.webservice.resources;

//POJO class which holds few parameters related to project that are displayed as response when get request is received.
public class ResponseProject {

	String projectName;
	Double projectCost;
	String projectUrl;
	String message;	
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(Double projectCost) {
		this.projectCost = projectCost;
	}
	
	public String getProjectUrl() {
		return projectUrl;
	}
	
	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
