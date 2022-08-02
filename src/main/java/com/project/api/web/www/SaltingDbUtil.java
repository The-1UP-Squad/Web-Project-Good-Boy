package com.project.api.web.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

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
			
			String sql = "select * from userinfo order by username";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				String uName = myRs.getString("username");
				
				Salting tempSalting = new Salting(uName);
				salting.add(tempSalting);
				}
				return salting;
			}
			finally {close(myConn, myStmt, myRs);	
			}
		}
		
		private void close()
			
	}
}