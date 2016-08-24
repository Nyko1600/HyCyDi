<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Hospital Malargue</title>


<%-- <c:url value="/resources/css/bootstrap.css" var="bootstrapCss" /> --%>
<%-- <c:url value="/resources/css/style.css" var="styleCss" /> --%>
<%-- <c:url value="/resources/js/jquery-ui.css" var="jqueryUiCss" /> --%>

<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"></c:url>'>
<%-- <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"></c:url>'> --%>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/jquery-ui.css"></c:url>'> 


<c:url value="/resources/js/jquery-ui.js" var="jqueryUiJs" /> 
<script src="${jqueryUiJs}"></script>

<script src="/resources/js/jquery-1.12.0.min.js" ></script> 
<%-- <script src="<c:url value="/resources/js/jquery-ui.js" />"></script> --%>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/jquery.js" />"></script>


</head>
