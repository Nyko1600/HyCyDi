<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"/>

<c:url value="/resources/js/jquery-ui.js" var="jqueryUiJs" />
<script src="${jqueryUiJs}"></script>

   <c:url value="/resources/js/bootstrap.js" var="bootstrapJs" />
<script src="${bootstrapJs}"></script>

<c:url value="/resources/js/jquery-1.12.0.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>   
</head>