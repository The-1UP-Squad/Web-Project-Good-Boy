package com.project.api.web.www;

public class Employee {
	
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String serviceLine;
	private String other;
	
	public Employee(String fName, String lName, String email, String serviceLine, String other) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.serviceLine = serviceLine;
		this.other = other;
	}

	public Employee(int id, String fName, String lName, String email, String serviceLine, String other) {
		
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.serviceLine = serviceLine;
		this.other = other;
	}
	

	public Employee(String fName, String lName, String email, int id) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.id = id;
	}

	public Employee(String fName, String lName, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}

	public Employee(int employeeId, String firstName, String lastName, String email) {
		this.fName = firstName;
		this.lName = lastName;
		this.email = email;
		this.id = employeeId;
				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String serviceLine) {
		this.serviceLine = serviceLine;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", serviceLine="
				+ serviceLine + ", other=" + other + "]";
	}
	

}
