<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<%@include file="../includes.jsp"%>

<body class="skin-blue">
<%@include file="../header.jsp"%>
		<!-- Site wrapper -->
		<div class="wrapper">
		<%@include file="../sideBar.jsp"%>
		
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper" style="min-height: 858px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>Location List </h1>
			</section><!-- Content Header (Page header) -->
			
			<!-- Main content -->
			<section class="content">
			<div class="container-fluid">
			<div class="row">
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>ID</th>
				        <th>Student Id</th>
				        <th>First Name</th>
						<th>Last Name</th>
						<th>Barcode</th>
				        <sec:authorize access="hasRole('ADMIN') ">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${studentList}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.firstname}</td>
						<td>${student.lastname}</td>
						<td>${student.barcode}</td>
					    <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/edit-student-${student.id}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/delete-student-${student.id}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
			<div>
			<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newCourse' />">Add New Student</a>
		 	</div>
	 	</sec:authorize>
			</div>
			</div>
			</section><!-- Main content -->
			
			</div><!-- Content Wrapper. Contains page content -->
			<%@include file="../footer.jsp"%>			
		</div><!-- Site wrapper -->
<%@include file="../scripts.jsp"%>

 	<%-- <div class="generic-container">
		<%@include file="authheader.jsp" %>
		<div class="well lead">User Registration Form</div>
	 	
	</div> --%>
</body>
</html>