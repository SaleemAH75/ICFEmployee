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

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
					
			</div>
			<br>
			<div class="conatiner col-md-5">
			<table class="jumbotron table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
                        <th>FName</th>
     					<th>LName</th>
	 					<th>DOJ</th>
						<th>Department</th>
	                    <th>Salary</th>
	 					<th>Experience</th>
     					<th>Address</th>
	 					<th>Education_Details</th>
	 					<th>Contact_No</th>
	 					<th>Email_Id</th>
	 					<th>Active_Status</th>
	 					<th>Edit</th>
	 					<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listEmployee}">
						
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.FName}" /></td>
							<td><c:out value="${user.LName}" /></td>
							<td><c:out value="${user.DOJ}" /></td>
							<td><c:out value="${user.department}" /></td>
							<td><c:out value="${user.salary}" /></td>
							<td><c:out value="${user.experience}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.education_Details}" /></td>
							<td><c:out value="${user.contact_No}" /></td>
							<td><c:out value="${user.email_Id}" /></td>
							<td><c:out value="${user.active_Status}" /></td>
							<td><a href="edit?Id=<c:out value='${user.id}' />">Edit</a></td>
							<td><a
								href="delete?Id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			</div>
		</div>
	</div>
</body>
</html>