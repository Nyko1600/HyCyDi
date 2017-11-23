<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<c:forEach var="css" items="${stylesheets}">
	        <link href="<c:url value="${css}"/>" rel="stylesheet" type="text/css">
	</c:forEach>
</head>
<title><tiles:getAsString name="title"/></title>
<body>

	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body"/>


	<c:forEach var="script" items="${javascripts}">
	        <script src="<c:url value="${script}"/>"></script>
	</c:forEach>
</body>
</html>