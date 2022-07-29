package com.project.api.web.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ServiceLineDbUtil {
	
	private DataSource dataSource;
	
	public ServiceLineDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;}
	
	public List<ServiceLine> getServiceLines() throws Exception {
		
		List<ServiceLine> serviceline = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from serviceline order by serviceline";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int slid = myRs.getInt("ServID");
				String slname = myRs.getString("ServLine");
				
				ServiceLine tempServiceLine = new ServiceLine(slid, slname);
				serviceline.add(tempServiceLine);
				}
				return serviceline;	
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
	
	public void addServiceLine(ServiceLine theServiceLine) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "INSERT INTO serviceline"
						+ "(ServiceLine)"
						+ "values (?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, theServiceLine.getSlid());
			myStmt.setString(2, theServiceLine.getSlname());
			
			myStmt.execute();
			}
		finally {
			
			close(myConn, myStmt, null);
		}
		
	}
}
