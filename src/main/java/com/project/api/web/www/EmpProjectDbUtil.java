package com.project.api.web.www;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				String pName = myRs.getString("Project");
				String fName = myRs.getString("Name");
				String startDate = myRs.getString("Start_Date");
				String endDate = myRs.getString("End_Date");
				
				EmployeeProject tempEmpProject = new EmployeeProject(pName, fName, startDate, endDate);
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
					+ "(Project) "
					+ "values (?)";
			
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
	}