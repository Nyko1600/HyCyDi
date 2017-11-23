<!DOCTYPE HTML>
<%@ include file="/WEB-INF/views/defaultTemplate/includes.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
		<!-- link rel="icon" href="<c:url value="/static/images/favicon.ico"/>" type="image/x-icon" />  -->
		<!-- <link rel="shortcut icon" href="<c:url value="/static/images/favicon.ico"/>" type="image/x-icon" />  -->
					
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"/>
	</head>
    <body>
  		
    	
		<button class="btn btn-default"> Hello</button>
		
		
		<tiles:insertAttribute name="scripts"/>
	</body>
</html>