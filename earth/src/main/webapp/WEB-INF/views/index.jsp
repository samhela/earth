<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>EARTH Project | Login</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.2 -->
<c:url value='/resources/bootstrap/css/bootstrap.min.css' var="url" />
<link href="${url}" rel="stylesheet" type="text/css">
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<c:url value="/resources/dist/css/AdminLTE.min.css" var="url" />
<link href="${url}" rel="stylesheet" type="text/css">
<!-- iCheck -->
<c:url value="/resources/plugins/iCheck/square/blue.css" var="url" />
<link href="${url}" rel="stylesheet" type="text/css">

</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href='<c:url value="/"/>'><b>EARTH Project</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">

			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Alert.</p>
					<c:out value="${param.message}" />
				</div>
			</c:if>

			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>

			<p class="login-box-msg">Sign in to start your session</p>
			<c:url var="login" value="login"></c:url>
			<f:form action="${login}" commandName="user" method="post"
				role="form">
				<div class="form-group has-feedback">

					<input type="text" class="form-control" id="username" name="userName"
						placeholder="Enter Username" required> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter Password" required> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> Remember Me
							</label>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<input type="submit" name="submit" value="Sign In"
							class="btn btn-primary btn-block btn-flat">

					</div>

					<!-- /.col -->
				</div>
				<div class="row">
					<div class="col-xs-8">
						<a href="#">I forgot my password</a>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<a id="signUp" href="newuser">Sign Up Here..</a>
					</div>

					<!-- /.col -->
				</div>
			</f:form>



			<!-- Registration Modal -->

			<div class="modal fade" id="signUpModal" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Sign Up</h4>
						</div>
						<div class="modal-body"></div>

					</div>

				</div>

			</div>
			<!-- Registration Modal -->

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.1.3 -->
	<c:url value="/resources/plugins/jQuery/jQuery-2.1.3.min.js" var="url" />
	<script src="${url}" type="text/javascript"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<c:url value="/resources/bootstrap/js/bootstrap.min.js" var="url" />
	<script src="${url}" type="text/javascript"></script>
	<!-- iCheck -->
	<c:url value="/resources/plugins/iCheck/icheck.min.js" var="url" />
	<script src="${url}" type="text/javascript"></script>

</body>
</html>

