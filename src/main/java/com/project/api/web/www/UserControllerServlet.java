package com.project.api.web.www;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserControllerServlet hello
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDbUtil userDbUtil;
	private ProjectDbUtil projectDbUtil;
	
	@Resource(name="jdbc/webapi")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our user db util .. and pass in the conn pool / data source
		try {
			userDbUtil = new UserDbUtil(dataSource);
			projectDbUtil = new ProjectDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {

				theCommand = "LISTEMPLOYEES";

			}
			
			switch(theCommand){
				
				case "LISTEMPLOYEES":
					listEmployees(request, response);
					break;
					
				case "ADDEMPLOYEE":
					addEmployee(request, response);
					break;
					
				case "LISTPROJECTS":
					listProjects(request, response);
					break;
					
				case "ADDPROJECT":
					addProject(request, response);
					break;
				
				case "DELETEEMPLOYEES":
					deleteEmployee(request, response);
					break;
					
				default:
					listEmployees(request, response);
					}
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


        private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
		
		//read student id form from id
        String theEmployeeID = request.getParameter("EmpId");	
        	
        //delete student from data base
        userDbUtil.deleteEmployee(theEmployeeID);	
        
        //send them back to servlet or index page, right?
        listEmployees(request, response); //not sure about this line??
	}


		private void addProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        	String pName = request.getParameter("pName");
        	
        	Project theProject = new Project(pName);
        	
        	projectDbUtil.addProject(theProject);
          	
        	listProjects(request, response);
	}
        
		private void listProjects(HttpServletRequest request, HttpServletResponse response) 
	        	throws Exception {
			// get users from db util
	        	List<Project> projects = projectDbUtil.getProjects();
	        	
	        // add users to the request
	        	request.setAttribute("PROJECT_LIST", projects);
	        	
	        // send to jsp page
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	        	dispatcher.forward(request, response);
			
		}




		private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        	String fName = request.getParameter("fName");
        	String lName = request.getParameter("lName");
        	String email = request.getParameter("email");
        	
        	Employee theEmployee = new Employee(fName, lName, email);
        	
        	userDbUtil.addEmployee(theEmployee);
        	
        	listEmployees(request, response);
        	
	}





		private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
        	throws Exception {
		// get users from db util
        	List<Employee> employees = userDbUtil.getEmployees();
        	
        // add users to the request
        	request.setAttribute("EMPLOYEE_LIST", employees);
        	
        // send to jsp page
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        	dispatcher.forward(request, response);
		
	}

}
