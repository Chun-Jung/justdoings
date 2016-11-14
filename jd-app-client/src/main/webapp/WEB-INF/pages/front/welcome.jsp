<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css/normalize.css" var="normalizeCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/myStyle.css" var="myStyleCss" />
<spring:url value="/resources/css/welcome.css" var="welcomeCss" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<link rel="stylesheet" href="${normalizeCss }">
<link rel="stylesheet" href="${bootstrapCss }">
<link rel="stylesheet" href="${myStyleCss }">
<link rel="stylesheet" href="${welcomeCss }">
<title>Justdoings</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/front/nav.jspf" %>
	<%@include file="/WEB-INF/pages/front/ad.jspf" %>
	<div class="container welcome-body">
		<c:forEach var="act" items="${recommendActList }">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="recommendAct">
					<div>
						<a href="<%=request.getContextPath() %>/act/find/${act.actSeq }">
							<!-- 如果沒有檔名，那就取預設的影像 -->
							<c:if test="${empty act.posterFileName }">
								<img class="poster-img" alt="${act.title }" src="<%=request.getContextPath() %>/file/default/<%=StatusEnum.Act.ordinal() %>" >
							</c:if>
							<c:if test="${not empty act.posterFileName }">
								<img class="poster-img" alt="${act.title }" src="<%=request.getContextPath() %>/file/userupload/${act.posterFileName }" >
							</c:if>
						</a>
					</div>
					<a href="<%=request.getContextPath() %>/act/find/${act.actSeq }">${act.title }</a>
					<div class="row">
						<div class="col-xs-7 col-sm-7 col-md-7">
							<div class="gov">
								<c:if test="${empty act.organizer.imgFileName }">
									<img class="icon30" alt="${act.organizer.name }" src="<%=request.getContextPath() %>/file/default/<%=StatusEnum.Orginizer.ordinal() %>" >
								</c:if>
								<c:if test="${not empty act.organizer.imgFileName }">
									<img class="icon30" alt="${act.organizer.name }" src="<%=request.getContextPath() %>/file/userupload/${act.organizer.imgFileName }">
								</c:if>
								${act.organizer.name }
							</div>
						</div>
						<div class="col-xs-5 col-sm-5 col-md-5">
							<span class="time">
								<span class="glyphicon glyphicon-time"></span>
								${act.beginDt.toString().substring(0,10) }
							</span>
						</div>
					</div>
					<div>
						<span class="browse">
							<span class="glyphicon glyphicon-eye-open"></span>
							${act.clickNo}
						</span> 
						<span class="bookmark">
							<span class="glyphicon glyphicon-bookmark"></span>
							0
						</span>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<script src="${jqueryJs }"></script>
	<script src="${bootstrapJs }"></script>
</body>
</html>