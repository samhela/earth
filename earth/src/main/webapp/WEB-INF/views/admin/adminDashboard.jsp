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
                <div class="row">
                    <p>I have main content</p>
                    <div class="container">
                        <table id="usersList" class="display" width="100%">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email </th>

                            </tr>
                            </thead>

                            <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>

                            </tr>
                            </tfoot>
                        </table>
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
<script type="application/javascript">

    $(document).ready(function() {
        $('#usersList').DataTable({
            "processing" : true,
            "ajax" : {
                "url" : "/user/userGrid",
                "type": "POST",
                dataSrc : ''
            },
            "columns": [
                { "data": "userName" },
                { "data": "password" },
                { "data": "firstName" },
                { "data": "lastName" },
                { "data": "email" },
            ]

        });

    });


</script>
</body>
</html>
