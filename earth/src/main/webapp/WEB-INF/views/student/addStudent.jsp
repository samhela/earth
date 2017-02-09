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
                <div class="row">
                    <form:form method="POST" modelAttribute="student" class="form-horizontal">
                        <form:input type="hidden" path="id" id="id"/>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="studentId">Student Id</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="studentId" id="studentId" class="form-control input-sm"/>
                                    <div class="has-error">
                                        <form:errors path="studentId" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="firstname">First Name</label>
                            <div class="col-md-4">
                                <form:input type="text" path="firstname" id="firstname" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="firstname" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="lastname">First Name</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="lastname" id="lastname" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="lastname" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="barcode">Description</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="barcode" id="barcode" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="barcode" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="row">
                            <div class="form-actions floatRight">
                                <c:choose>
                                    <c:when test="${edit}">
                                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/student/studentList' />">Cancel</a>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/student/studentList' />">Cancel</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </form:form>
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