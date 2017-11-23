<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title><tiles:getAsString name="title"/></title>
	<c:forEach var="css" items="${stylesheets}">
	        <link href="<c:url value="${css}"/>" rel="stylesheet" type="text/css">
	</c:forEach>		
</head>

<body>

	<tiles:insertAttribute name="header"/>
		
	<sec:authorize access="isAuthenticated()" >
		<tiles:insertAttribute name="menu"/>
	</sec:authorize>
	<tiles:insertAttribute name="body"/>
	
	
	<c:forEach var="script" items="${javascripts}">
	        <script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	
	<c:if test="${not empty other_js}">
		<c:forEach var="script" items="${other_js}">
	        <script src="<c:url value="${script}"/>"></script>
		</c:forEach>
	</c:if>
</body>
</html>