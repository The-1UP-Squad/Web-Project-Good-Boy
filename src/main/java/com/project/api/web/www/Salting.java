
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
	public static void encrptPass(String[] args) {
		
		int notthekey = 6;
		String myCode = "Hello my name is Matthew";
		//ArrayList<Character> nope = new ArrayList <Character>(); 
		System.out.println(myCode);
		String name="";
		char[] myArray = myCode.toCharArray();
		
		for(char n : myArray) {
			n += notthekey;
			//nope.add(n);
			name += n;
			System.out.print(n);
			

		}
		System.out.println(" ");
		//String var =nope.addAll(nope);
		//System.out.println(name);
	}
	
	public static void decrptPass(String[] args) {
		
		int notthekey = 6;
		String myCode = "Nkrru&s&tgsk&oy&Sgzznk}";
		//ArrayList<Character> nope = new ArrayList <Character>(); 
		System.out.println(myCode);
		String name="";
		char[] myArray = myCode.toCharArray();
		
		for(char n : myArray) {
			n -= notthekey;
			//nope.add(n);
			name += n;
			System.out.print(n);
			

		}
		System.out.println(" ");
		//String var =nope.addAll(nope);
		//System.out.println(name);
	}
}
