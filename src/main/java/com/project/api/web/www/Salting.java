
package com.project.api.web.www;

import java.util.ArrayList;

public class Salting {
	
	private int userid;
	private String uName;
	private String passWord;
	
	public Salting(int userid, String uName, String passWord) {
		
		this.userid = userid;
		this.uName = uName;
		this.passWord = passWord;
	}
	
	public Salting(String uName, String passWord) {
		
		this.uName = uName;
		this.passWord = passWord;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	@Override
	public String toString() {
		return "Salting [userid=" + userid + ", uName=" + uName + ", passWord=" + passWord + "]";
	}

}
