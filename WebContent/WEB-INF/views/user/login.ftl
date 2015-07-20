<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<#assign base=springMacroRequestContext.getContextUrl("")>
<meta http-equiv="Cache-Control" content="no-store"/><!-- HTTP 1.1 -->
        <meta http-equiv="Pragma" content="no-cache"/><!-- HTTP 1.0 -->
        <meta http-equiv="Expires" content="0"/><!-- Prevents caching at the Proxy Server -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
        <link rel="icon" href="${base}/images/favicon.ico" />
        <script type="text/javascript">
			LOTTERY = {base:'${base}'};
		</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${base}/scripts/jquery/jquery-1.10.1.min.js"></script>
	<script src="${base}/scripts/jquery/jquery.validate.js"/></script>
	<script src="${base}/scripts/jquery/additional-methods.js"/></script>
	<link href="${base}/styles/jqueryValidation/screen.css" rel="stylesheet" type="text/css"/>
	<link href="${base}/styles/common/cpsystem.css" rel="stylesheet" type="text/css" />
	<link href="${base}/styles/common/reset.css" rel="stylesheet" type="text/css" />
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
			        	<input type="text" class="logininputbg" style="width:160px;" id="jcaptchaPassword" name="jcaptchaPassword" value="" tabindex="3"/>
			      	 </div>
			      	 <div class="yzm"><img src="<@c.url value="/jcaptcha"/>" id="jcaptchaImg" name="jcaptchaImg" title="看不清楚,点击换一个" alt="验证码" onclick="this.src='${base}/jcaptcha?t'+new Date().getTime();"/></div>
			      	 <div class="k20"></div>
      				 <div class="btlogin"><a href="#"><img src="${base}/images/loginbt.gif" border="0" id="loginImg" /></a></div>
				 	 
				</form>
				<#if errorMsg?exists&&errorMsg?has_content>
					 <div id="errorDiv" style="color: red;font-size: 18; margin-top: 23px; text-align: center;">
					 	${errorMsg}
					 </div>
			 	 </#if>
			</div>
		</div>
	</div>
<div id="copyright">Copyright 2008-2012  All Rights Reserved<br />
<script src="${base}/scripts/index/login.js"></script>
</body>
</html>