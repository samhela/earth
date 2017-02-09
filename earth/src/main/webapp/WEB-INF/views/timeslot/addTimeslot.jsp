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
            <h1>Add new timeslot </h1>
        </section><!-- Content Header (Page header) -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <form:form method="POST" modelAttribute="timeslot" class="form-horizontal">
                        <form:input type="hidden" path="id" id="id"/>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="timeslotId">Abrevation</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="timeslotId" id="timeslotId" class="form-control input-sm"/>
                                    <div class="has-error">
                                        <form:errors path="courseId" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="name">Course Name</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="name" id="name" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="name" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="description">Description</label>
                                <div class="col-md-4">
                                    <form:input type="text" path="description" id="description" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="description" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="row">
                            <div class="form-actions floatRight">
                                <c:choose>
                                    <c:when test="${edit}">
                                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/user/list' />">Cancel</a>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/user/list' />">Cancel</a>
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