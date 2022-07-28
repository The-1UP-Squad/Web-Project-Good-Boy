package com.project.api.web.www;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

public class ProjectDbUtil {

	private DataSource dataSource;
	
	public ProjectDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;}
	
	
	public List<Project> getProjects() throws Exception {
		
		List<Project> projects = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from Projects order by Project";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int projId = myRs.getInt("ProID");
				String pName = myRs.getString("Project");
				
				Project tempProject = new Project(projId, pName);
				projects.add(tempProject);
			}
		
			return projects; 
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

	public void addProject(Project theProject) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			myConn = dataSource.getConnection();
			
			String sql = "insert into Projects"
					+ "(Project) "
					+ "values (?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, theProject.getProjId());
			myStmt.setString(1, theProject.getprojName());
			
			
			myStmt.execute();
			
		}
		finally {
			
			close(myConn, myStmt, null);
		}
		
	}
	
	public void deleteProject(String theProjects) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
	
		try {
			//convert employee id to int
			int ProjId = Integer.parseInt(theProjects);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete student
			String sql = "delete from Projects where ProID=?";
			
			//prep statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, ProjId);
			
			//execute sql statement
			myStmt.execute();
			
		}
		finally {
			//clean up JDBC code
			close(myConn, myStmt, null);
		}
		
}
	}