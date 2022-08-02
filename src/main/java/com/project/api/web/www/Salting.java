package com.project.api.web.www;

public class Salting {
	
	public static void main(String[] args) {
		
		int notthekey = 6;
		String myCode = "Hello my name is Matthew";
		
		System.out.println(myCode);
		
		char[] myArray = myCode.toCharArray();
		
		for(char n : myArray) {
			n += notthekey;
			System.out.print(n);

		}
	}

}
