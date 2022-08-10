package com.project.api.web.www;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

public class EmpProjectDbUtil {

	private DataSource dataSource;
	
	public EmpProjectDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;}
	
	
	public List<EmployeeProject> getEmployeeProjects() throws Exception {
		
		List<EmployeeProject> employeeProjects = new ArrayList<>();
		
		Connection myConn = null; 
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from addprojects order by Project";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int id = myRs.getInt("ProjectID");
				String pName = myRs.getString("Project");
				String fName = myRs.getString("Name");
				String startDate = myRs.getString("Start_Date");
				String endDate = myRs.getString("End_Date");
				
				EmployeeProject tempEmpProject = new EmployeeProject(id, pName, fName, startDate, endDate);
				employeeProjects.add(tempEmpProject);
			}
		
			return employeeProjects; 
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

	public void addEmployeeProject(EmployeeProject theEmpProject) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			myConn = dataSource.getConnection();
			
			String sql = "insert into addprojects"
					+ "(Project,Name,Start_Date,End_Date) "
					+ "values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmpProject.getpName());
			myStmt.setString(2, theEmpProject.getfName());
			myStmt.setString(3, theEmpProject.getStartDate());
			myStmt.setString(4, theEmpProject.getEndDate());
			
			myStmt.execute();
			
		}
		finally {
			
			close(myConn, myStmt, null);
		}
		
	}


	public EmployeeProject getEmployeeProject(String theEmployeeProjectID) throws Exception{
	   EmployeeProject theEmployeeProject ; 
	   PreparedStatement myStmt = null;
	   Connection myConn = null;
	   ResultSet myRs = null;
	   int employeeProjectId;

	   try {
		   employeeProjectId = Integer.parseInt(theEmployeeProjectID);
		   
		   myConn = dataSource.getConnection();
		   
		   String sql = "select * from addprojects where ProjectID =?";
		   
		   myStmt = myConn.prepareStatement(sql);
		   
		   myStmt.setInt(1, employeeProjectId);
		   
		   myRs = myStmt.executeQuery();
		   
		   if (myRs.next()) {
			   String pName = myRs.getString("Project");
			   String firstName = myRs.getString("Name");
			   String startDate = myRs.getString("Start_Date");
			   String endDate = myRs.getString("End_Date");
	;		  
			   theEmployeeProject = new EmployeeProject(employeeProjectId, pName, firstName, startDate, endDate);
		   }
		   else {
			   throw new Exception ("could not find id:" + employeeProjectId);
		   }
					   
		   
		  
		     
		   return theEmployeeProject;
	   }
		finally {
			close(myConn, myStmt, myRs);
			}
	}
	public void deleteEmployeeProject(String theEmployeeProjectID) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
	
		try {
			//convert employee id to int
			int id = Integer.parseInt(theEmployeeProjectID);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete student
			String sql = "delete from addprojects where ProjectID=?";
			
			//prep statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, id);
			
			//execute sql statement
			myStmt.execute();
			
		}
		finally {
			//clean up JDBC code
			close(myConn, myStmt, null);}
		}
		public void updateProjects(EmployeeProject theEmployeeProject)throws Exception {
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			
			try {
				
		
			    myConn = dataSource.getConnection();
//				String sql = "update addprojects"
//						+" set Project=?, Name=?, Start_Date=?, End_Date=?" 
//						+" where ProjectID=?;";
			    
			    String sql = "update addprojects set Project=?, Name=?, Start_Date=?, End_Date=? where ProjectID=?";
				
				
				myStmt = myConn.prepareStatement(sql);
				
				
				myStmt.setString(1, theEmployeeProject.getpName());
				myStmt.setString(2, theEmployeeProject.getfName());
			    myStmt.setString(3, theEmployeeProject.getStartDate());
			    myStmt.setString(4, theEmployeeProject.getEndDate());
				myStmt.setInt(5, theEmployeeProject.getpId());
				
				
			myStmt.execute();
				
				}
			finally {
				close(myConn, myStmt, null);
		}
	}}