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
			<h1>Users List </h1>
			</section><!-- Content Header (Page header) -->
			
			<!-- Main content -->
			<section class="content">
			<div class="container-fluid">
			<div class="row">
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>User Name</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.userName}</td>
					    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/edit-user-${user.userName}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/delete-user-${user.userName}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
			<div>
			<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newuser' />">Add New User</a>
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