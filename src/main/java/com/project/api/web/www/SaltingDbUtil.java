package com.project.api.web.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class SaltingDbUtil {
	
	private DataSource dataSource;
	
	public SaltingDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;}
		
	public List<Salting> getSalting() throws Exception {
		
		List<Salting> salting = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from usersinfo order by username";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int userid = myRs.getInt("userID");
				String uName = myRs.getString("username");
				String passWord = myRs.getString("password");
				
				Salting tempSalting = new Salting(uName, passWord);
				salting.add(tempSalting);
				}
				return salting;
			}
			finally {close(myConn, myStmt, myRs);	
			}
		}
		
		private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
			try {
				if (myRs != null) {
					myRs.close();
				}
				if (myStmt != null) {
					myStmt.close();
				}
				if (myConn != null) {
					myConn.close();
				}
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
	     }
		
		public void addSalting(Salting theSalting) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			
			try {
				
				int notthekey = 6;
				String myCode = (theSalting.getPassWord());
				String name="";
				char[] myArray = myCode.toCharArray();
				
				for(char n : myArray) {
					n += notthekey;
					name += n;
					
				}
				
				myConn = dataSource.getConnection();
				
				String sql = "INSERT INTO usersinfo"
						+ "(username, password)"
						+ "values (?,?)";
				
				myStmt = myConn.prepareStatement(sql);
				
				myStmt.setString(1, theSalting.getuName());
				myStmt.setString(2, name);
				
				myStmt.execute();
				
			}
			finally {
				
				close(myConn, myStmt, null);
			}
		}
		
		public Salting getSalting(String theSaltingID) throws Exception {
			
			Salting theSalting = null;
			PreparedStatement myStmt = null;
			Connection myConn = null;
			ResultSet myRs = null;
			int SaltingID;
			
			try {
				SaltingID = Integer.parseInt(theSaltingID);
				
				myConn = dataSource.getConnection();
				
				String sql = "SELECT * FROM usersinfo WHERE userID =?";
				
				myStmt = myConn.prepareStatement(sql);
				
				myStmt.setInt(1, SaltingID);
				
				myRs = myStmt.executeQuery();
				
				if (myRs.next()) {
					String uName = myRs.getString("username");
					String passWord = myRs.getString("password");
					
					theSalting = new Salting(SaltingID, uName, passWord);
				}
				else {
					throw new Exception ("Password Id not found:" + SaltingID);
				}
				
				return theSalting;
			}
			finally {
				close(myConn, myStmt, myRs);
			}
		}
		
		
		public static void main(String[] args) {
			
			int notthekey = 6;
			String myCode = "inxoy789";
			//ArrayList<Character> nope = new ArrayList <Character>(); 
			//System.out.println(myCode);
			String name="";
			char[] myArray = myCode.toCharArray();
			
			for(char n : myArray) {
				n -= notthekey;
				//nope.add(n);
				name += n;
				System.out.print(n);
				

			}
			
		}
}
