 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> Employee Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${emp == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${emp != null}">
					<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>FName <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.FName}' />" class="form-control"
						name="FName" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>LName <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.LName}' />" class="form-control"
						name="LName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>DOJ <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.DOJ}' />" class="form-control"
						name="DOJ" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Department <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.department}' />" class="form-control"
						name="Department" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Salary</label> <input type="text"
						value="<c:out value='${emp.salary}' />" class="form-control"
						name="Salary">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Experience</label>
					<select name="Experience" class="form-control">
						<c:if test="${emp.experience == 'Yes'}">
							<option value ="Yes" selected>Yes</option>
							<option value ="No">No</option>
						</c:if>
						<c:if test="${emp.experience == 'No'}">
							<option value ="Yes" >Yes</option>
							<option value ="No" selected>No</option>
						</c:if>
						<c:if test="${emp.experience == null}">
							<option value ="Yes" >Yes</option>
							<option value ="No">No</option>
						</c:if>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${emp.address}' />" class="form-control"
						name="Address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Education Details</label> <input type="text"
						value="<c:out value='${emp.education_Details}' />" class="form-control"
						name="Education_Details">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Contact No <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.contact_No}' />" class="form-control"
						name="Contact_No" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email_Id <sup style="color:red;">*</sup></label> <input type="text"
						value="<c:out value='${emp.email_Id}' />" class="form-control"
						name="Email_Id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Active Status</label>
					<select name="Active_Status" class="form-control">
						<c:if test="${emp.active_Status == 'Active'}">
							<option value ="Active" selected>Active</option>
							<option value ="InActive">InActive</option>
						</c:if>
						<c:if test="${emp.active_Status == 'InActive'}">
							<option value ="Active" >Active</option>
							<option value ="InActive" selected>InActive</option>
						</c:if>
						<c:if test="${emp.active_Status == null}">
							<option value ="Active" >Active</option>
							<option value ="InActive">InActive</option>
						</c:if>
					</select>
				</fieldset>
				
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>