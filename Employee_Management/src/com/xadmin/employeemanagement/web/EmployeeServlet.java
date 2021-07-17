package com.xadmin.employeemanagement.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xadmin.employeemanagement.dao.EmployeeOperations;
import com.xadmin.employeemanagement.bean.Employee;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;	
	private EmployeeOperations EmployeeOperations;
	
	public void init() throws ServletException
	{
		EmployeeOperations = new EmployeeOperations();//call EmployeeOperation by using object//
	}
    //handling all request in a single method//
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String action = request.getServletPath();
	     //handling request//
		    try {
				switch (action) 
				{
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertEmployee(request, response);
					break;
				case "/update":
					updateEmployee(request, response);
					break;
				case "/delete":
					deleteEmployee(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				default:
					listEmployee(request, response);
					break;
				}
		    }
				catch (SQLException ex) 
				{
					throw new ServletException(ex);
				}
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		} 

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");//Forwarding request to from.jsp//
		dispatcher.forward(request, response);
	}
    //Extracting employee details from Employee object//
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		String FName = request.getParameter("FName");
		String LName = request.getParameter("LName");
		String DOB = request.getParameter("DOB");
		String Gender = request.getParameter("Gender");
        String DOJ = request.getParameter("DOJ");
		String Department = request.getParameter("Department");
		double Salary = Double.parseDouble(request.getParameter("Salary"));
		String Experience = request.getParameter("Experience");
		String Address = request.getParameter("Address");
		String Education_Details = request.getParameter("Education_Details");
		String Start_Date = request.getParameter("Start_Date");
		String End_Date = request.getParameter("End_Date");
        String Institute = request.getParameter("Institute");
		double Percentage = Double.parseDouble(request.getParameter("Percentage"));
        String Contact_No = request.getParameter("Contact_No");
		String Email_Id = request.getParameter("Email_Id");
		String Active_Status = request.getParameter("Active_Status");
		Employee newEmp = new Employee(FName, LName,DOB,Gender, DOJ, Department, Salary, Experience, Address, Education_Details, Start_Date, End_Date, Institute, Percentage,Contact_No,Email_Id,Active_Status);
		EmployeeOperations.insertEmployee(newEmp);
		response.sendRedirect("list");
	}
     //passing the information to update employee method to update details in database//
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int Id = Integer.parseInt(request.getParameter("id"));
		String FName = request.getParameter("FName");
		String LName = request.getParameter("LName");
		String DOB = request.getParameter("DOB");
		String Gender = request.getParameter("Gender");
		String DOJ = request.getParameter("DOJ");
		String Department = request.getParameter("Department");
		double Salary = Double.parseDouble(request.getParameter("Salary"));
		String Experience = request.getParameter("Experience");
		String Address = request.getParameter("Address");
		String Education_Details = request.getParameter("Education_Details");
		String Start_Date = request.getParameter("Start_Date");
		String End_Date = request.getParameter("End_Date");
		String Institute = request.getParameter("Institute");
		double Percentage = Double.parseDouble(request.getParameter("Percentage"));
		String Contact_No = request.getParameter("Contact_No");
		String Email_Id = request.getParameter("Email_Id");
		String Active_Status = request.getParameter("Active_Status");

		Employee book = new Employee(Id, FName, LName, DOB, Gender, DOJ, Department, Salary, Experience, Address, Education_Details, Start_Date, End_Date , Institute, Percentage, Contact_No,Email_Id,Active_Status);
		EmployeeOperations.updateEmployee(book);
		response.sendRedirect("list");
	}              
    //once the details deleted we redirect to the  employee list page//
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int Id = Integer.parseInt(request.getParameter("Id"));
		EmployeeOperations.deleteEmployee(Id);
		response.sendRedirect("list");
	}
	//employee from to edit,insert employee object//
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int Id = Integer.parseInt(request.getParameter("Id"));
		Employee existingEmployee = EmployeeOperations.selectEmployee(Id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("emp", existingEmployee);
		dispatcher.forward(request, response);
	}
	//default data//
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{
		List<Employee> listEmployee = EmployeeOperations.selectAllEmployers();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
}