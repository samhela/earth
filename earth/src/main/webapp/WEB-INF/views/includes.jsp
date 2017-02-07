<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>EARTH</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.2 -->  
    <c:url value='/resources/bootstrap/css/bootstrap.min.css' var="url" />
    <link href="${url}" rel="stylesheet" type="text/css" media="screen">       
    <!-- DatePicker CSS -->
    <link href="<c:url value="/resources/plugins/datepicker/datepicker3.css" />" rel="stylesheet" type="text/css"/>
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
   <!-- Theme style -->
    <c:url value="/resources/dist/css/AdminLTE.min.css" var="url" />
    <link href="${url}" rel="stylesheet" type="text/css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <c:url value="/resources/dist/css/skins/_all-skins.min.css" var="url" />
    <link href="${url}" rel="stylesheet" type="text/css">    
   
</head>
