
package com.project.api.web.www;

import java.util.ArrayList;
import java.util.List;

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
	
	public static String doingTheSalt(String theSalting) {
		
		
		String name="";
		try {
			
			int notthekey = 6;
			String myCode = (theSalting);
			
			char[] myArray = myCode.toCharArray();
			
			for(char n : myArray) {
				n += notthekey;
				name += n;
				
			}	
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}
		return name;
	}
	
	@Override
	public String toString() {
		return "Salting [userid=" + userid + ", uName=" + uName + ", passWord=" + passWord + "]";
	}

}
