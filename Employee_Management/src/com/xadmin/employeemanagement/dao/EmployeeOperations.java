package com.xadmin.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xadmin.employeemanagement.bean.Employee;

//jdbc related operations//
public class EmployeeOperations {
	
	 //insert employees to employee table statements//
		private static final String INSERT_EMPLOYERS_SQL = "INSERT INTO employee" + " (FName, LName, DOB , Gender, DOJ, Department, Salary, Experience, Address, Education_Details,Start_Date,End_Date, Institute, Percentage, Contact_No, Email_Id, Active_Status) VALUES "
				+ " (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		private static final String SELECT_EMPLOYERS_BY_ID = "select Id, FName, LName, DOB, Gender, DOJ, Department, Salary, Experience, Address, Education_Details,Start_Date,End_Date, Institute, Percentage, Contact_No, Email_Id, Active_Status from employee where Id =?";
		private static final String SELECT_ALL_EMPLOYERS = "select * from employee"; 
		private static final String DELETE_EMPLOYERS_SQL = "delete from employee where Id = ?;";
		private static final String UPDATE_EMPLOYERS_SQL = "update employee set FName = ?,LName= ?, DOB= ?, Gender= ?, DOJ =?, Department= ?, Salary= ?, Experience= ?, Address= ?, Education_Details= ?, Start_Date= ?, End_Date= ?, Institute= ?, Percentage= ?, Contact_No= ?, Email_Id= ?, Active_Status=? where Id = ?;";
		public EmployeeOperations() 
		{
		}
		protected Connection getConnection() 
		{
			Connection connection = null;
			 String jdbcURL = "jdbc:mysql://localhost:3306/Employee_Db?useSSL=false";
			 String jdbcUsername = "root";
			 String jdbcPassword = "root";
			 String jdbcDriver ="com.mysql.cj.jdbc.Driver";
			try 
			{
				
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		
		public void insertEmployee(Employee emp) throws SQLException 
		{
			System.out.println(INSERT_EMPLOYERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYERS_SQL)) 
			{
				preparedStatement.setString(1, emp.getFName());
				preparedStatement.setString(2, emp.getLName());
				preparedStatement.setString(3, emp.getDOB());
				preparedStatement.setString(4, emp.getGender());
				preparedStatement.setString(5, emp.getDOJ());
				preparedStatement.setString(6, emp.getDepartment());
				preparedStatement.setDouble(7, emp.getSalary());
				preparedStatement.setString(8, emp.getExperience());
				preparedStatement.setString(9, emp.getAddress());
				preparedStatement.setString(10, emp.getEducation_Details());
				preparedStatement.setString(11, emp.getStart_Date());
				preparedStatement.setString(12, emp.getEnd_Date());
				preparedStatement.setString(13, emp.getInstitute());
				preparedStatement.setDouble(14, emp.getPercentage());
				preparedStatement.setString(15, emp.getContact_No());
				preparedStatement.setString(16, emp.getEmail_Id());
				preparedStatement.setString(17, emp.getActive_Status());
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} 
			catch (SQLException e) 
			{
				printSQLException(e);
			}
		}

		public Employee selectEmployee(int Id) 
		{
			Employee emp = null;
			// Step 1: Establishing a Connection//
			try (Connection connection = getConnection();
				 // Step 2:Create a statement using connection object//
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYERS_BY_ID);) 
			 {
				 preparedStatement.setInt(1, Id);
				 System.out.println(preparedStatement);
				 // Step 3: Execute the query or update query//
				 ResultSet rs = preparedStatement.executeQuery();

				 // Step 4: Process the ResultSet object.//
				 while (rs.next()) 
				 {
					String FName = rs.getString("FName");
					String LName = rs.getString("LName");
					String DOB = rs.getString("DOB");
					String Gender = rs.getString("Gender");
					String DOJ = rs.getString("DOJ");
					String Department = rs.getString("Department");
					double Salary = rs.getDouble("Salary");
					String Experience = rs.getString("Experience");
					String Address = rs.getString("Address");
					String Education_Details = rs.getString("Education_Details");
					String Start_Date = rs.getString("Start_Date");
					String End_Date = rs.getString("End_Date");
					String Institute = rs.getString("Institute");
					double Percentage = rs.getDouble("Percentage");
					String Contact_No = rs.getString("Contact_No");
					String Email_Id = rs.getString("Email_Id");
					String Active_Status = rs.getString("Active_Status");
					emp = new Employee(Id, FName, LName, DOB, Gender, DOJ, Department, Salary, Experience, Address, Education_Details, Start_Date, End_Date, Institute, Percentage, Contact_No,Email_Id,Active_Status);
				 }
			} 
			catch (SQLException e) 
			{
				printSQLException(e);
			}
			return emp;
		}

		public List<Employee> selectAllEmployers() 
		{

			// using try-with-resources to avoid closing resources //
			List<Employee> employee = new ArrayList<>();
			// Step 1: Establishing a Connection//
			try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object//
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYERS);) 
			  {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query//
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.//
				while (rs.next()) 
				{
					int Id = rs.getInt("Id");
					String FName = rs.getString("FName");
					String LName = rs.getString("LName");
					String DOB = rs.getString("DOB");
					String Gender = rs.getString("Gender");
					String DOJ = rs.getString("DOJ");
					String Department = rs.getString("Department");
					double Salary = rs.getDouble("Salary");
					String Experience = rs.getString("Experience");
					String Address = rs.getString("Address");
					String Education_Details = rs.getString("Education_Details");
					String Start_Date = rs.getString("Start_Date");
					String End_Date = rs.getString("End_Date");
					String Institute = rs.getString("Institute");
					double Percentage = rs.getDouble("Percentage");
					String Contact_No = rs.getString("Contact_No");
					String Email_Id = rs.getString("Email_Id");
					String Active_Status = rs.getString("Active_Status");
					employee.add(new Employee(Id, FName, LName, DOB, Gender, DOJ, Department, Salary, Experience, Address, Education_Details, Start_Date, End_Date, Institute, Percentage,  Contact_No, Email_Id, Active_Status));
				}
			 } 
			catch (SQLException e) 
			{
				printSQLException(e);
			}
			return employee;
		}
		
		public boolean updateEmployee(Employee emp) throws SQLException 
		{
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYERS_SQL);) 
			{
				System.out.println("updated Employee:"+ statement);
				statement.setString(1, emp.getFName());
				statement.setString(2, emp.getLName());
				statement.setString(3, emp.getDOB());
				statement.setString(4, emp.getGender());
	            statement.setString(5, emp.getDOJ());
				statement.setString(6, emp.getDepartment());
				statement.setDouble(7, emp.getSalary());
				statement.setString(8, emp.getExperience());
				statement.setString(9, emp.getAddress());
				statement.setString(10, emp.getEducation_Details());
				statement.setString(11, emp.getStart_Date());
				statement.setString(12, emp.getEnd_Date());
				statement.setString(13, emp.getInstitute());
				statement.setDouble(14, emp.getPercentage());
				statement.setString(15, emp.getContact_No());
				statement.setString(16, emp.getEmail_Id());
				statement.setString(17, emp.getActive_Status());
				statement.setInt(18, emp.getId());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
	     //step:5  Delete users//
		public boolean deleteEmployee(int Id) throws SQLException 
		{
			boolean rowDeleted;
			try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYERS_SQL);) 
			 {
				statement.setInt(1, Id);
				rowDeleted = statement.executeUpdate() > 0;
			 }
			return rowDeleted;
		}

		private void printSQLException(SQLException ex) 
		{
			for (Throwable e : ex) 
			{
				if (e instanceof SQLException) 
				{
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) 
					{
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}

}
