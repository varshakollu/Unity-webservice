package com.varsha.unity.webservice.resources;

import java.util.Arrays;
import java.util.List;

//POJO class which holds all the parameters pertaining to a project
public class Project {

	private int id;
	private String projectName;
	private String creationDate;
	private String expiryDate;
	private boolean enabled;
	private String [] targetCountries;
	private double projectCost;
	private String projectUrl;
	private List<TargetKeys> targetKeys;
	
	public Project(){}
		
	public Project(int id, String projectName, String creationDate, String expiryDate, boolean enabled,
			String[] targetCountries, double projectCost, String projectUrl, List<TargetKeys> targetKeys) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.creationDate = creationDate;
		this.expiryDate = expiryDate;
		this.enabled = enabled;
		this.targetCountries = targetCountries;
		this.projectCost = projectCost;
		this.projectUrl = projectUrl;
		this.targetKeys = targetKeys;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", creationDate=" + creationDate + ", expiryDate="
				+ expiryDate + ", enabled=" + enabled + ", targetCountries=" + Arrays.toString(targetCountries)
				+ ", projectCost=" + projectCost + ", projectUrl=" + projectUrl + ", targetKeys=" + targetKeys + "]";
	}

	//Getters and Setters for the variables of Project class
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String[] getTargetCountries() {
		return targetCountries;
	}
	
	public void setTargetCountries(String[] targetCountries) {
		this.targetCountries = targetCountries;
	}
	
	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}
	
	public String getProjectUrl() {
		return projectUrl;
	}
	
	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}
	
	public List<TargetKeys> getTargetKeys() {
		return targetKeys;
	}
	
	public void setTargetKeys(List<TargetKeys> targetKeys) {
		this.targetKeys = targetKeys;
	}
}



