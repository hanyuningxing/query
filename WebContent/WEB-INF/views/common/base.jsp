<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="cssBasePath" value="${contextPath}/styles" />
<c:set var="scriptBasePath" value="${contextPath}/scripts" />
<c:set var="imagesBasePath" value="${contextPath}/images" />
<script src="../scripts/jquery/jquery-1.10.1.min.js"></script>
<link href="${cssBasePath }/common/cpsystem.css" rel="stylesheet" type="text/css" />
<link href="${cssBasePath }/common/reset.css" rel="stylesheet" type="text/css" />
<%
	response.setHeader("Cache-Control","no-cache,no-strore");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires",-1); 
%>
<link ref="icon"  href="favicon.ico" type="image/x-icon"/ >
<link ref="shortcut icon"  href="favicon.ico" type="image/x-icon"/ >