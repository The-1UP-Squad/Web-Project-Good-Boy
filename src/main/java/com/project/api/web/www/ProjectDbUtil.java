package com.project.api.web.www;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProjectDbUtil {

	private DataSource dataSource;
	
	public ProjectDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Project> getProject() throws Exception {
		
		List<Project> project = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		Resultset myRs = null;
		
		return project;
	}
}