package com.project.api.web.www;

import java.io.IOException;
import java.util.ArrayList;
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

	private static final String theEmployeeProjectID = null;
	
	private UserDbUtil userDbUtil;
	private ProjectDbUtil projectDbUtil;
	private EmpProjectDbUtil EmpProjectDbUtil;
	private ServiceLineDbUtil serviceLineDbUtil;
	private SaltingDbUtil saltingDbUtil;
	
	@Resource(name="jdbc/webapi")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our user db util .. and pass in the conn pool / data source
		try {
			userDbUtil = new UserDbUtil(dataSource);
			projectDbUtil = new ProjectDbUtil(dataSource);
			EmpProjectDbUtil = new EmpProjectDbUtil(dataSource);
			serviceLineDbUtil = new ServiceLineDbUtil (dataSource);
			saltingDbUtil = new SaltingDbUtil(dataSource);
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
					
				case "LISTEMPLOYEEPROJECTS":
					listEmployeeProjects(request, response);
					break;
					
				case "ADDEMPLOYEEPROJECT":
					addEmployeeProject(request, response);
					break;
					
				case "DELETEEMPLOYEEPROJECT":
					deleteEmployeeProject(request, response);
					break;

				case "LISTSERVICELINES":
					listServiceLine(request, response);
					break;
					
				case "ADDSERVICELINE":
					addServiceList(request, response);
          				break;

				case "LOAD":
					loadEmployees(request, response);
					break;
	
				case "DELETEPROJECT":
					deleteProject(request, response);
					break;
					
				case "UPDATE":
					updateEmployee(request, response);
					break;
				
				case "ADDUSERPASSWORD":
					addUserPassword(request, response);
					break;
				
				case "CHECKUSERPASSWORD":
					checkUserPassword(request, response);
					break;

				case "UPDATEINDEX":
					updateProjects(request, response);
					break;
					
				default:
					listEmployees(request, response);
					}
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void checkUserPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		List<Salting> salting = saltingDbUtil.getSalting();
		
		Salting testSalt = new Salting(uName, passWord);
   	 
    	request.setAttribute("SALTING_LIST", salting);
    	
    	for(Salting salt: salting) {
    		
    		int notthekey = 6;
			String myCode = (passWord);
			String name="";
			char[] myArray = myCode.toCharArray();
			
			for(char n : myArray) {
				n += notthekey;
				name += n;
		
			}
			
    		if (salt.getuName().equals(testSalt.getuName())) {
    			
    			if (salt.getPassWord().equals(name)) {
    				listEmployeeProjects(request, response);
    			}

    		else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
    		dispatcher.forward(request, response);
    		}
    		}
    	}
    	}


	private void addUserPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uName = request.getParameter("uName");
		String passWord = request.getParameter("passWord");
		
		Salting theSalting = new Salting(uName, passWord);
		
		saltingDbUtil.addSalting(theSalting);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

	}
		

	private void updateProjects(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{ 
		int pId = Integer.parseInt(request.getParameter("employeeProject"));
		String pName = request.getParameter("project");
	    String fName = request.getParameter("employee");
	    String startDate = request.getParameter("startdate");
	    String endDate = request.getParameter("enddate");
    	
    	listEmployeeProjects(request, response);
	    
	    EmployeeProject theEmployeeProject = new EmployeeProject(pId, pName, fName, startDate, endDate);
	    
	    EmpProjectDbUtil.updateProjects(theEmployeeProject);
	    
	    listEmployees(request, response);
	    
	}


	private void deleteEmployeeProject(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		//read student id form from id
        String theEmployeeProjectID = request.getParameter("ProjectID");	
        	
        //delete student from data base
        EmpProjectDbUtil.deleteEmployeeProject(theEmployeeProjectID);
        
        listEmployeeProjects(request, response);
    }
		


	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{ 
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("fName");
	    String lastName = request.getParameter("lName");
	    String email = request.getParameter("email");
	    
	    Employee theEmployee = new Employee(id, firstName, lastName, email);
	    
	    userDbUtil.updateEmployee(theEmployee);
	    
	    listEmployees(request, response);
	    
	    }


	private void loadEmployees(HttpServletRequest request, HttpServletResponse response) 
        	throws Exception{ 
        	
			List<Project> projects = projectDbUtil.getProjects();
    	
    		request.setAttribute("PROJECT_LIST", projects);
    	
    		List<Employee> employees = userDbUtil.getEmployees();
    	
        	request.setAttribute("EMPLOYEE_LIST", employees);
        	//read student id form from id
            String theEmployeeProjectID = request.getParameter("ProjectID"); 
            

            EmployeeProject theEmployeeProject = EmpProjectDbUtil.getEmployeeProject(theEmployeeProjectID);
            
            request.setAttribute("THE_EMPLOYEEPROJECT", theEmployeeProject);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/modify.jsp");
            dispatcher.forward(request, response);
        	
		 
	}


		private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
		
		//read student id form from id
        String theEmployeeID = request.getParameter("EmpId");	
        	
        //delete student from data base
        userDbUtil.deleteEmployee(theEmployeeID);
        
        //send them back to servlet or index page, right?

        listEmployees(request, response);//not sure about this line??
        }

        private void addEmployeeProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        	
        	String pName = request.getParameter("pName");
        	String fName = request.getParameter("fName");
        	String startDate = request.getParameter("startDate");
        	String endDate = request.getParameter("endDate");
        	
        	EmployeeProject theEmpProject = new EmployeeProject(pName, fName, startDate, endDate);
        	
        	EmpProjectDbUtil.addEmployeeProject(theEmpProject);
        	
        	listEmployeeProjects(request, response);
	}


		private void listEmployeeProjects(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int modifywhereto = 0;
		
		if (request.getParameter("modifywhereto") != null) {
			modifywhereto = Integer.parseInt(request.getParameter("modifywhereto"));
		}
		
		List<EmployeeProject> theEmployeeProject = EmpProjectDbUtil.getEmployeeProjects();
		
		request.setAttribute("EMPLOYEEPROJECT_LIST", theEmployeeProject);
		
		
		if (modifywhereto == 1) {
			
			List<Project> projects = projectDbUtil.getProjects();
        	
        	request.setAttribute("PROJECT_LIST", projects);
        	
        	List<Employee> employees = userDbUtil.getEmployees();
        	
            request.setAttribute("EMPLOYEE_LIST", employees);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/modify.jsp");
			dispatcher.forward(request, response);
			
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
	}


		private void addProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        	String pName = request.getParameter("pName");
        	
        	Project theProject = new Project(pName);
        	
        	projectDbUtil.addProject(theProject);
          	
        	listProjects(request, response);
	}
        
		private void listProjects(HttpServletRequest request, HttpServletResponse response) 
	        	throws Exception {
			int whereTo = 0;
			
			if (request.getParameter("whereTo") != null) {
				whereTo = Integer.parseInt(request.getParameter("whereTo"));
			}
			
        		List<Employee> employees = userDbUtil.getEmployees();
        	
        		request.setAttribute("EMPLOYEE_LIST", employees);

	        	List<Project> projects = projectDbUtil.getProjects();
	        	
	        	request.setAttribute("PROJECT_LIST", projects);
	        	
	        // send to jsp page
			
	        if (whereTo == 2) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/addproject.jsp");
		        dispatcher.forward(request, response);
	        	
	        } else {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		        dispatcher.forward(request, response);
	        	}
		}




		private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        	String fName = request.getParameter("fName");
        	String lName = request.getParameter("lName");
        	String email = request.getParameter("email");
        	String serviceLine = request.getParameter("serviceLine");
        	Employee theEmployee = new Employee(fName, lName, email, serviceLine);
        	
        	userDbUtil.addEmployee(theEmployee);
        	
        	listEmployees(request, response);
        	
        	
	}





		private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
        	throws Exception {
			int whereTo = 0;
			
			if (request.getParameter("whereTo") != null) {
				whereTo = Integer.parseInt(request.getParameter("whereTo"));
			}
		// get users from db util
        	List<Employee> employees = userDbUtil.getEmployees();
        	
        // add users to the request
        	request.setAttribute("EMPLOYEE_LIST", employees);
        	
        	List<ServiceLine> serviceLines = serviceLineDbUtil.getServiceLines();
        	 
        	request.setAttribute("SERVICELINE_LIST", serviceLines);

         	List<EmployeeProject> theEmployeeProject = EmpProjectDbUtil.getEmployeeProjects();
    		
         	request.setAttribute("EMPLOYEEPROJECT_LIST", theEmployeeProject);
        	
        // send to jsp page

        	if (whereTo == 1) {
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/adduser.jsp");
	        	dispatcher.forward(request, response);
	        	
        	} else {
	        	if(response.isCommitted()) {
	        		return;
	        	}
	        	RequestDispatcher dispatcher2 = request.getRequestDispatcher("/index.jsp");
	        	
	        	dispatcher2.forward(request, response);
        	}  			
        
		}
		
		
		private void deleteProject(HttpServletRequest request, HttpServletResponse response)
		        throws Exception {
				
				//read student id form from id
		        String pName = request.getParameter("ProID");
		        
		        //Project theProjects = new Project(pName);
		        	
		        //delete student from data base
		        //ProjectDbUtil.deleteProject(theProjectID);
		        
		        projectDbUtil.deleteProject(pName);
		  
		        
		        //send them back to servlet or index page, right?

		        listProjects(request, response);//not sure about this line??
		        }
		


private void listServiceLine(HttpServletRequest request, HttpServletResponse response) 
    	throws Exception {
		int whereTo = 0;
		
		if (request.getParameter("whereTo") != null) {
			whereTo = Integer.parseInt(request.getParameter("whereTo"));
		}

    	List<ServiceLine> serviceLines = serviceLineDbUtil.getServiceLines();
    	

    	request.setAttribute("SERVICELINE_LIST", serviceLines);
    	
    

    	if (whereTo == 1) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/addserviceline.jsp");
        	dispatcher.forward(request, response);
        	
    	} else {
    		listEmployees(request, response);}
    	}  			
    private void addServiceList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    		
        String slname = request.getParameter("slname");
        	
        	
        ServiceLine theServiceLine = new ServiceLine(slname);
        	
        serviceLineDbUtil.addServiceLine(theServiceLine);
        	
        listServiceLine(request, response);
        	
	} 
    	
	}
