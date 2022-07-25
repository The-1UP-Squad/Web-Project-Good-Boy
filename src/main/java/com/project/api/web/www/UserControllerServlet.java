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
	
	@Resource(name="jdbc/webapi")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		// create our user db util .. and pass in the conn pool / data source
		try {
			userDbUtil = new UserDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}




	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
				
				case "LIST":
					listEmployees(request, response);
					break;
					
				case "ADD":
					addEmployee(request, response);
					break;
					
				default:
					listEmployees(request, response);
					}
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


        private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        	String fName = request.getParameter("fName");
        	String lName = request.getParameter("lName");
        	String email = request.getParameter("email");
        	
        	Employee theEmployee = new Employee(fName, lName, email);
        	
        	UserDbUtil.addEmployee(theEmployee);
        	
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
