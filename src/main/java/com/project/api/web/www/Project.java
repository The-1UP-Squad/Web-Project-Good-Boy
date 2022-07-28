package com.project.api.web.www;

public class Project {


	private int projId;
	private String projName;
	
	public int getProjId() {
		return projId;
	}
	
	public void setProjId(int projId) {
		this.projId = projId;
	}
	
	public String getprojName() {
		return projName;
	}
	
	public void setprojName(String projName) {
		this.projName = projName;
	}
	
	public Project(int projId, String projName) {
		this.projId = projId;
		this.projName = projName;
	}
	

	public Project(String pName) {
		this.projName = pName;
	}
	
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", pName=" + projName + "]";
	}

}