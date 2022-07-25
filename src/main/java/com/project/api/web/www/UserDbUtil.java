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
		//	int id = myRs.getInt("EmpId");
			String fName = myRs.getString("First_Name");
			String lName = myRs.getString("Last_Name");
			String email = myRs.getString("Email_address");
		//	String serviceLine = myRs.getString("serviceLine");
		//	String other = myRs.getString("other");
			Employee tempEmployee = new Employee(fName, lName, email);
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
}
