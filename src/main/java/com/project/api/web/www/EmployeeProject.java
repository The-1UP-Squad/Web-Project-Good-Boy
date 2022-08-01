package com.project.api.web.www;

public class EmployeeProject {
	
	private int pId;
	private String pName;
	private String fName;
	private String startDate;
	private String endDate;
	
	public EmployeeProject(int pId, String pName, String fName, String startDate, String endDate) {
		
		this.pId = pId;
		this.pName = pName;
		this.fName = fName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public EmployeeProject(String pName, String fName, String startDate, String endDate) {
		
		
		this.pName = pName;
		this.fName = fName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "EmployeeProject [pId=" + pId + ", pName=" + pName + ", fName=" + fName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}

