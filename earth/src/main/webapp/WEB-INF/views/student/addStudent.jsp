<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h1>Add new Student </h1>
        </section><!-- Content Header (Page header) -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row col-md-8">
                    <!-- Account Information -->
                    <form:form action="/student/addStudent1" method="post"  data-toggle="validator" >
                        <input type="hidden" id="userId" name="userId" />
                        <div class="form-group">
                            <label for="txtStudentId">Student Id </label>
                            <input type="text" class="form-control" name="txtStudentId" id="txtStudentId" placeholder="Student Id" required>
                        </div>
                        <div class="form-group">
                            <label for="txtFirstName">First Name</label>
                            <input type="text" class="form-control" name="txtFirstName" id="txtFirstName"  placeholder="Enter First Name" required>
                        </div>
                        <div class="form-group">
                            <label for="txtLastName">Last name </label>
                            <input type="text" class="form-control" name="txtLastName" id="txtLastName" placeholder="Enter LastName" required>
                        </div>
                        <div class="form-group">
                            <label for="txtBarcode">Barcode</label>
                            <input type="text" class="form-control" name="txtBarcode" id="txtBarcode" placeholder="Enter Barcode" required>
                        </div>
                        <div class="form-group">
                            <label for="txtDescription">Description</label>
                            <input type="text" class="form-control" name="txtDescription" id="txtDescription" placeholder="Enter Description" required>
                        </div>


                        <div class="form-group">
                            <label for="txtUserName">User Name</label>
                            <input type="text" class="form-control" name="txtUserName" id="txtUserName" placeholder="Enter User Name" required>
                        </div>
                        <div class="form-group">
                            <label for="txtPassword">Password</label>
                            <input type="password" class="form-control" name="txtPassword" id="txtPassword" pattern="^(?=.{6,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$" placeholder="Enter Passord" required>
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input type="text" class="form-control" name="txtEmail" id="txtEmail" placeholder="Enter Email" required>
                        </div>


                        <button type="button" class="btn btn-default" >Close</button>
                        <input type="submit" class="btn btn-primary" value="Save" />


                    </form:form>
                        <!-- Account information -->
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