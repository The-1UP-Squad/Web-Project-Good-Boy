package com.project.api.web.www;
import java.sql.Connection;
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
		String sql = "select * from employee order by lName";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);
		while (myRs.next()) {
			int id = myRs.getInt("id");
			String fName = myRs.getString("fName");
			String lName = myRs.getString("lName");
			String email = myRs.getString("email");
			String serviceLine = myRs.getString("serviceLine");
			String other = myRs.getString("other");
			Employee tempEmployee = new Employee(id, fName, lName, email, serviceLine, other);
			employees.add(tempEmployee);
		}
	
		return employees;}
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
}
