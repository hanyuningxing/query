<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/views/common/base.jsp"%>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="scripts/jquery/jquery.validate.js"></script>
	<script src="scripts/jquery/additional-methods.js"></script>
	<link rel="stylesheet" href="styles/jqueryValidation/screen.css" />
  	<title>出票查询系统</title>
</head>
<body>
	<div class="m100">
		<div class="loginbg">
			<div class="loginwz">
				<form method="post" id="loginForm">
					<div class="c14qingse">用户名</div>
					<div class="fl">
        			<input type="text" class="logininputbg" name="username" id="username" tabindex="1"/>
      				</div>
      				
      				<div class="k20"></div>
			        <div class="c14qingse">密 码</div>
			        <div class="fl">
			          <input type="password" class="logininputbg" id="password" name="password" tabindex="2"/>
			        </div>
			        
			         <div class="k20"></div>
			      	 <div class="c14qingse">验证码</div>
			      	 <div class="fl">
			        	<input type="text" class="logininputbg" style="width:160px;" id="jcaptchaPassword" name="jcaptchaPassword" value="请输入验证码" tabindex="3"/>
			      	 </div>
			      	 <div class="yzm"><img src="jcaptcha" id="jcaptchaImg" name="jcaptchaImg" title="看不清楚,点击换一个" alt="验证码" onclick="this.src='${ctx}/jcaptcha?t'+new Date().getTime();"/></div>
			      	 <div class="k20"></div>
      				 <div class="btlogin"><a href="#"><img src="images/loginbt.gif" border="0" id="loginImg" /></a></div>
				 	 
				</form>
				<c:if test="${errorMsg != null }">
					 <div id="errorDiv" style="color: red;font-size: 18; margin-top: 23px; text-align: center;">
					 	<c:out value="${errorMsg }"></c:out>
					 </div>
			 	 </c:if>
			</div>
		</div>
	</div>
 <div id="copyright">Copyright 2008-2012  All Rights Reserved<br />
<script src="scripts/index/login.js"></script>
</body>
</html>