package com.project.api.web.www;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

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