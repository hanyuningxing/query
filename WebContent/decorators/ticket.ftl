<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
	<script src="${base}/jquery/ui/js/jquery-ui-1.10.3.custom.js"/></script>
	<link href="${base}/jquery/ui/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
	
	<script src="${base}/jquery/ui/js/jquery-ui-timepicker-addon.js"/></script>
	<link href="${base}/jquery/ui/css/jquery-ui-timepicker-addon.css" rel="stylesheet" type="text/css" />
	<link href="${base}/styles/jqueryValidation/screen.css" rel="stylesheet" type="text/css"/>
	<link href="${base}/styles/common/cpsystem.css" rel="stylesheet" type="text/css" />
	<link href="${base}/styles/common/reset.css" rel="stylesheet" type="text/css" />
  	<title>玉米科技出票查询系统</title>
</head>
<body>
<div class="dtop">
  <div class="d1000"> <a href="#" class="dlogo"></a>
    <div class="dicon"> <a href="#" class="dicon1">订单查询</a> <a href="#" class="dicon2">充值</a> <a href="#" class="dicon3">提款</a> <a href="#" class="dicon4">资金明细</a> </div>
  </div>
  <div class="charwelcome">您好，<span class="namegreen">${user.userName}</span>&nbsp;&nbsp;当前额度：<span class="moneychar">现金:${user.remainMoney?string("###,###.##")}</span>&nbsp;&nbsp;<a href="#">刷新余额</a> | <a href="#">[退出]</a></div>
</div>
<!-- top  end-->
<div class="d1000">
    <div class="mleft">
    <div class="mleftban">商户基本信息</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="#"  class="now">账户信息</a></li>
        <li><a href="#">修改密码</a></li>
      </ul>
    </div>
    <div class="mleftban">出票信息管理 </div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="#">日志查询</a></li>
        <li><a href="${base}/ticket">订单查询</a></li>
        <li><a href="#">撤单数据</a></li>
        <li><a href="#">限号列表</a></li>
      </ul>
    </div>
    <div class="mleftban">报表信息</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="#" >资金明细 </a></li>
        <li><a href="#">资金统计报表</a></li>
        <li><a href="#">出票统计</a></li>
      </ul>
    </div>
    <div class="mleftb1">
      <div class="k10"></div>
      <div class="top1px"> 值班客服QQ：<a target="_blank" href=" http://wpa.qq.com/msgrd?v=3&uin=812081180&site=qq&menu=yes"><img src="${base}/images/qq.gif" align="absmiddle" />812081180</a><br />
        值班客服电话：400 688 4944<br />
        主管电话：<b class="bluetel">135 8060 5828 </b><br />
      </div>
    </div>
  </div>
     ${body}
</div>
<div class="k10"></div>
<!-- copyright begin-->
<div id="copyright">Copyright 2008-2012  All Rights Reserved<br />
  深圳市玉米科技信息科技有限公司 客服热线：4006884944 邮箱:miyugao@163.com</div>
</body>
</html>
