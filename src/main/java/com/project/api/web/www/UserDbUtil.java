package com.project.api.web.www;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {
	private DataSource dataSource;
	
	public UserDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
public List<Employee> getEmployees() throws Exception {
	List<Employee> employees = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt= null;
	ResultSet myRs= null;
	
	try {
		myConn = dataSource.getConnection();
		
		String sql = "select * from Employees order by Last_Name";
		myStmt = myConn.createStatement();
		
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			int id = myRs.getInt("EmpId");
			String fName = myRs.getString("First_Name");
			String lName = myRs.getString("Last_Name");
			String email = myRs.getString("Email_address");
		//	String serviceLine = myRs.getString("serviceLine");
		//	String other = myRs.getString("other");
			Employee tempEmployee = new Employee(fName, lName, email, id);
			employees.add(tempEmployee);
		}
	
		return employees; 
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

public void addEmployee(Employee theEmployee) throws Exception {
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		
		myConn = dataSource.getConnection();
		
		String sql = "insert into Employees "
				+ "(First_Name, Last_Name, Email_address) "
				+ "values (?, ?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setString(1, theEmployee.getfName());
		myStmt.setString(2, theEmployee.getlName());
		myStmt.setString(3, theEmployee.getEmail());
		
		myStmt.execute();
		
	}
	finally {
		
		close(myConn, myStmt, null);
	}
	
}

	public void deleteEmployee(String theEmployeeID) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
	
		try {
			//convert employee id to int
			int id = Integer.parseInt(theEmployeeID);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete student
			String sql = "delete from employees where EmpID=?";
			
			//prep statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, id);
			
			//execute sql statement
			myStmt.execute();
			
		}
		finally {
			//clean up JDBC code
			close(myConn, myStmt, null);
		}
		
	
}
	public Employee getEmployee(String theEmployeeID) throws Exception{
		   Employee theEmployee = null; 
		   PreparedStatement myStmt = null;
		   Connection myConn = null;
		   ResultSet myRs = null;
		   int employeeId;
		   
		   try {
			   employeeId = Integer.parseInt(theEmployeeID);
			   
			   myConn = dataSource.getConnection();
			   
			   String sql = "select * from employees where EmpID =?";
			   
			   myStmt = myConn.prepareStatement(sql);
			   
			   myStmt.setInt(1, employeeId);
			   
			   myRs = myStmt.executeQuery();
			   
			   if (myRs.next()) {
				   String firstName = myRs.getString("First_Name");
				   String lastName = myRs.getString("Last_Name");
				   String email = myRs.getString("Email_address");
				  
				   theEmployee = new Employee(employeeId, firstName, lastName, email );
			   }
			   else {
				   throw new Exception ("could not find id:" + employeeId);
			   }
						   
			   
			  
			     
			   return theEmployee;
		   }
			finally {
				close(myConn, myStmt, myRs);
				}
	}

	public void updateEmployee(Employee theEmployee)throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		
			myConn = dataSource.getConnection();
			String sql = "update employees "
					+ "set First_Name=?, last_Name=?, Email_address=? "
					+ "where EmpID=? ";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmployee.getfName());
			myStmt.setString(2, theEmployee.getlName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setInt(4, theEmployee.getId());
			
			myStmt.execute();
			
			}
		finally {
			close(myConn, myStmt, null);
	}
	}
}
