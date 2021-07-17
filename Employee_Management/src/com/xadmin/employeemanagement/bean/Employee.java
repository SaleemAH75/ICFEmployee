package com.xadmin.employeemanagement.bean;

public class Employee {
	
	private int Id;
	private String FName;
	private String LName;
	private String DOB;
	private String Gender;
	private String DOJ;
	private String Department;
	private double Salary;
	private String Experience;
	private String Address;
	private String Education_Details;
	private String Start_Date;
	private String End_Date;
	private String Institute;
    private double Percentage;
	private String Contact_No;
	private String Email_Id;
	private String Active_Status;
	
	public Employee(int Id, String FName, String LName, String DOB, String Gender, String DOJ, String Department, double Salary, String Experience,
			String Address, String Education_Details, String Start_Date, String End_Date, String Institute ,double Percentage, String Contact_No, String Email_Id, String Active_Status) {
		super();
		this.Id = Id;
		this.FName = FName;
		this.LName = LName;
		this.DOB=DOB;
		this.Gender=Gender;
		this.DOJ = DOJ;
		this.Department = Department;
		this.Salary = Salary;
		this.Experience = Experience;
		this.Address = Address;
		this.Education_Details = Education_Details;
		this.Start_Date=Start_Date;
		this.End_Date=End_Date;
		this.Institute=Institute;
		this.Percentage=Percentage;
		this.Contact_No = Contact_No;
		this.Email_Id = Email_Id;
		this.Active_Status = Active_Status;
	}
	
	//auto incrementing constructor//
	
	public Employee(String FName, String LName,  String DOB, String Gender, String DOJ, String Department, double Salary, String Experience, String Address,
			String Education_Details,String Start_Date, String End_Date, String Institute, double Percentage, String Contact_No, String Email_Id, String Active_Status) {
		super();
		this.FName = FName;
		this.LName = LName;
		this.DOB=DOB;
		this.Gender=Gender;
		this.DOJ = DOJ;
		this.Department = Department;
		this.Salary = Salary;
		this.Experience = Experience;
		this.Address = Address;
		this.Education_Details = Education_Details;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.Institute = Institute;
		this.Percentage = Percentage;
		this.Contact_No = Contact_No;
		this.Email_Id = Email_Id;
		this.Active_Status = Active_Status;
	}
	
	//getter and setter methods to access private fields//
	
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getFName() {
		return FName;
	}
	public void setFName(String FName) {
		this.FName = FName;
	}
	
	public String getLName() {
		return LName;
	}
	public void setLName(String LName) {
		this.LName = LName;
	}
	
    public String getDOB() {
	     return DOB;
       }

    public void setDOB(String DOB) {
    	this.DOB = DOB;
       }
    public String getGender() {
  	     return Gender;
          }

       public void setGender(String Gender) {
       	this.Gender = Gender;
          }
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String DOJ) {
		this.DOJ = DOJ;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String Department) {
		this.Department = Department;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double Salary) {
		this.Salary = Salary;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String Experience) {
		this.Experience = Experience;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getEducation_Details() {
		return Education_Details;
	}
	public void setEducation_Details(String Education_Details) {
		this.Education_Details = Education_Details;
	}
	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String Start_Date) {
		this.Start_Date = Start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String End_Date) {
		this.End_Date = End_Date;
	}
	public String getInstitute() {
   	     return Institute;
           }

           public void setInstitute(String Institute){
        	this.Institute = Institute;
           }
           public double getPercentage() {
  	   	     return Percentage;
  	           }

  	           public void setPercentage(double Percentage) {
  	        	this.Percentage = Percentage;
  	           }
	public String getContact_No() {
		return Contact_No;
	}
	public void setContact_No(String Contact_No) {
		this.Contact_No = Contact_No;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String Email_Id) {
		this.Email_Id = Email_Id;
	}
	public String getActive_Status() {
		return Active_Status;
	}
	public void setActive_Status(String Active_Status) {
		this.Active_Status = Active_Status;
	}
	
	@Override
	//Overriding toString method to print the object content//
	
	public String toString() {
		return "Employee [Id=" + Id + ", FName=" + FName + ", LName=" + LName  +  ",DOB="+ DOB +",Gender=" + Gender +" ,DOJ=" + DOJ + ", Department="
				+ Department + ", Salary=" + Salary + ", Experience=" + Experience + ", Address=" + Address
				+ ", Education_Details=" + Education_Details + ",Start_Date = " + Start_Date + ", End_Date=" + End_Date +",Institute="+ Institute +",Percentage="+ Percentage + ", Contact_No=" + Contact_No + ", Email_Id="
				+ Email_Id + ", Active_Status=" + Active_Status + "]";
	}


}
