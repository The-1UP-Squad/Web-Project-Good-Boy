package com.project.api.web.www;

public class ServiceLine {
	
	private int slid;
	private String slname;
	
	public ServiceLine(int slid, String slname) {
		
		this.slid = slid;
		this.slname = slname;
	}
	
	public ServiceLine(String slname) {
		
		this.slname = slname;
	}

	public int getSlid() {
		return slid;
	}

	public void setSlid(int slid) {
		this.slid = slid;
	}

	public String getSlname() {
		return slname;
	}

	public void setSlname(String slname) {
		this.slname = slname;
	}

	@Override
	public String toString() {
		return "ServiceLine [slid=" + slid + ", slname=" + slname + "]";
	}
}
