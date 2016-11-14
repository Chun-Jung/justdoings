<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css/normalize.css" var="normalizeCss" 
/><spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" 
/><spring:url value="/resources/css/myStyle.css" var="myStyleCss" 
/><spring:url value="/resources/css/welcome.css" var="welcomeCss" 
/><spring:url value="/resources/js/jquery.min.js" var="jqueryJs" 
/><spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" 
/><spring:url value="/resources/js/login.js" var="loginJs" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<link rel="stylesheet" href="${myStyleCss }">
<link rel="stylesheet" href="${welcomeCss }">
<title>登入畫面 - Justdoings</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/front/nav.jspf" %>
	<div class="container login-form">
		<div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 well">
			<section>
				<h2 class="text-center padding-form">會員登入</h2>
				<form class="form-horizontal" action="<%=request.getContextPath() %>/member/login" method="post">
					<input type="email" name="email" class="form-control padding-form" placeholder="電子郵件" required />
					<input type="password" name="password" class="form-control padding-form" placeholder="密碼" required />
					<a href="<%=request.getContextPath() %>/member/forgetPassword" class="text-right">忘記密碼</a>
					<button id="sign-in-btn" class="btn btn-primary btn-block padding-form">Sign in</button>
					
					<hr>
					<a href="<%=request.getContextPath() %>/member/register" class="text-right">註冊會員</a>
				</form>
				
			</section>
		</div>
	</div>
	<script src="${jqueryJs }"></script>
	<script src="${bootstrapJs }"></script>
	<script src="${loginJs }"></script>
</body>
</html>