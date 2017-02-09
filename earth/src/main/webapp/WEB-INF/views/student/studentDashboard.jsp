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
            <h1>Welcome to your Dashboard </h1>
        </section><!-- Content Header (Page header) -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="col-md-12">
                    <div class="tabbable" id="tab">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#usersList"
                                                  data-toggle="tab">Users List</a></li>
                            <li><a href="#editStudent" data-toggle="tab">Courses List
                                </a></li>
                            <li><a href="#locations" data-toggle="modal">Locations
                               </a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="usersList">
                            <p></p>
                                <table id="studentsListTable" class="display" width="100%">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Student Id</th>
                                        <th>First Name </th>
                                        <th>Last Name</th>
                                        <th>Barcode</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Student Id</th>
                                        <th>First Name </th>
                                        <th>Last Name</th>
                                        <th>Barcode</th>

                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <div class="tab-pane" id="editStudent">
                            <p></p>
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
                                            <td>${student.studentId}</td>
                                            <td>${student.firstname}</td>
                                            <td>${student.lastname}</td>
                                            <td>${student.barcode}</td>
                                            <sec:authorize access="hasRole('ADMIN')">
                                                <td><a href="<c:url value='/student/edit-student-${student.id}' />" class="btn btn-success custom-width">edit</a></td>
                                            </sec:authorize>
                                            <sec:authorize access="hasRole('ADMIN')">
                                                <td><a href="<c:url value='/student/delete-student-${student.id}' />" class="btn btn-danger custom-width">delete</a></td>
                                            </sec:authorize>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="container">

                    </div>
                </div>
            </div>
        </section> <!-- Main Content -->
    </div> <!-- Content Wrapper -->
    <%@include file="../footer.jsp"%>
</div> <!-- Site Wrapper -->
<%@include file="../scripts.jsp"%>
<link href="<c:url value="/resources/plugins/DataTables/jquery.dataTables.min.css" />" rel="stylesheet">

<script src="<c:url value="/resources/plugins/DataTables/jquery.dataTables.min.js" />"></script>
<script>
    $(document).ready(function() {
        $('#studentsListTable').DataTable( {
            "ajax": {
                "url": "/student/studentGrid",
                "dataSrc": "rows"
            },
            "columns": [
                { "data": "id" },
                { "data": "studentId" },
                { "data": "firstname" },
                { "data": "lastname" },
                { "data": "barcode" },


            ]
        } );

        $('#coursesListTable').DataTable( {
            "ajax": {
                "url": "/user/courseGrid",
                "dataSrc": "rows"
            },
            "columns": [
                { "data": "id" },
                { "data": "courseId" },
                { "data": "name" },
                { "data": "description" }

            ]
        } );
    } );
</script>
</body>
</html>
