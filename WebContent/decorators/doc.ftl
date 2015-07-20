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
			window.BASESITE='${base}';
		</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${base}/scripts/jquery/jquery-1.10.1.min.js"></script>
	<script src="${base}/scripts/jquery/jquery.validate.js"/></script>
	<script src="${base}/scripts/jquery/additional-methods.js"/></script>
	<script src="${base}/scripts/common/dateUtil.js"/></script>
	<script src="${base}/scripts/common/common.js"/></script>
	<script src="${base}/scripts/lottery/popup.js"/></script>
	
	<script src="${base}/jquery/ui/js/jquery-ui-1.10.3.custom.js"/></script>
	<script src="${base}/jquery/ui/js/dialog.js"/></script>
	<link href="${base}/jquery/ui/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
	<script src="${base}/jquery/ui/js/jquery-ui-timepicker-addon.js"/></script>
	<link href="${base}/jquery/ui/css/jquery-ui-timepicker-addon.css" rel="stylesheet" type="text/css" />
	<script src="${base}/jquery/ui/js/jquery.form.js"/></script>
	
	<link href="${base}/styles/common/cpsystem.css" rel="stylesheet" type="text/css" />
	<link href="${base}/styles/common/reset.css" rel="stylesheet" type="text/css" />

  	<title>玉米科技出票查询系统</title>
  	<style>
  	.doc_title_td1{border-left: 1px solid #DCE7F4;text-align: center}
  	.doc_title_td2{border-left: 1px solid #DCE7F4;text-align: left;word-break:break-all}
  	
  	.doc_td_1{text-align: center}
  	.doc_td_other{border-left: 1px solid #DCE7F4;text-align: center}
  	
  	.doc_td_head_1{text-align: center}
  	.doc_td_head_other{border-left: 1px solid #FFFFFF;text-align: center}
  	</style>
  	
</head>
<body>
<div class="dtop">
  <div class="d1000"> <a href="#" class="dlogo"></a>
    <div class="dicon"> <a href="${base}/ticket" class="dicon1">订单查询</a> <a href="#" class="dicon2">充值</a> <a href="#" class="dicon3">提款</a> <a href="${base}/user/fund" class="dicon4">资金明细</a> </div>
  </div>
 <#if user??>
  <div class="charwelcome">您好，<span class="namegreen">${user.userName}</span>&nbsp;&nbsp;当前额度：<span class="moneychar">现金:<span id="remainMoney_"><#if ticketPlatformInfo??>${ticketPlatformInfo.remainMoney?string("###,###.##")}</#if></span></span>&nbsp;&nbsp;<a href="#" onclick="getRemainMoney();return false;">刷新余额</a> | <a href="/user/logout">[退出]</a></div>
 </#if>
</div>
<script type="text/javascript">
			window.BASESITE='${base}';
			function getRemainMoney(){
		        Miracle.ajaxData({
		            url: '/user/remainMoney',
		            callBack:function(jsonObj){
					   var remainMoney_ = document.getElementById("remainMoney_");
					   remainMoney_.innerHTML = jsonObj.remainMoney;
		            }
		        });
		    }
		    function getSaleLottery(){
			        Miracle.getURL({
			            url: '/doc/saleLottery',
			            width:300,
			            title:'彩种选项',
			            modal:false
			        });
     	    }
     	    function getError(){
		        Miracle.getURL({
		            url: '/doc/error',
		            width:300,
		            title:'处理结果',
		            modal:false
		        });
		      }
</script>
<!-- top  end-->
<div class="d1000">
  <div class="mleft">
      <div class="mleftban">报表信息</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="${base}/ticket" >订单查询 </a></li>
        <li><a href="${base}/user/fund" >资金明细 </a></li>
        <li><a href="${base}/user/fdreport/init">资金统计报表</a></li>
        <li><a href="${base}/ticket/countquery">出票统计</a></li>
        <li><a href="${base}/ticket/limit">限号查询</a></li>
      </ul>
    </div>
    <div class="mleftban">出票接口约定</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="${base}/doc"  <#--class="now"-->>请求格式</a></li>
      </ul>
    </div>
    <div class="mleftban">接口相关接口 </div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="${base}/doc/time">同步时间接口（100）</a></li>
        <li><a href="${base}/doc/send">彩票发送接口（101）</a></li>
        <li><a href="${base}/doc/confirm">彩票查询接口（102）</a></li>
        <li><a href="${base}/doc/lotteryinfo">彩期查询接口（103）</a></li>
        <li><a href="${base}/doc/lotterymatch">竞技对阵查询接口(104)</a></li>
        <li><a href="${base}/doc/lotterymatch1">竞技开奖查询接口(105)</a></li>
        <li><a href="${base}/doc/remainMoney">余额查询接口(106)</a></li>
        <li><a href="${base}/doc/prize">奖金查询接口(107)</a></li>
        <li><a href="${base}/doc/prizeTicket">开奖查询接口(108)</a></li>
        <li><a href="${base}/doc/resultList">开奖号码查询(109)</a></li>
      </ul>
    </div>
    <div class="mleftban">彩种说明和格式</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
      	 <li><a href="${base}/doc/lottery?lottery=JCZQ" >竞彩足球 </a></li>
         <li><a href="${base}/doc/lottery?lottery=JCLQ">竞彩篮球</a></li>

         <li><a href="${base}/doc/numlottery?lottery=DLT">大乐透</a></li>
         <li><a href="${base}/doc/numlottery?lottery=PL">排列三/排列五</a></li>       
         <li><a href="${base}/doc/numlottery?lottery=SEVENSTAR">七星彩</a></li>
         <li><a href="${base}/doc/numlottery?lottery=TC22TO5">体彩22选5</a></li>
         <li><a href="${base}/doc/lottery?lottery=DCZC">北京单场</a></li>
         <li><a href="${base}/doc/lottery?lottery=SFZC">14场胜负彩/任选9场</a></li>
         <li><a href="${base}/doc/lottery?lottery=LCZC">六场半全场</a></li>
         <li><a href="${base}/doc/lottery?lottery=SCZC">四场进球</a></li>
         
         <li><a href="${base}/doc/numlottery?lottery=SSQ" >双色球 </a></li>       
         <li><a href="${base}/doc/numlottery?lottery=SEVEN">七乐彩</a></li>
         <li><a href="${base}/doc/numlottery?lottery=WELFARE3D">福彩3D</a></li>     
          <li><a href="${base}/doc/numlottery?lottery=KLPK">快乐扑克3</a></li>  
         <li><a href="${base}/doc/numlottery?lottery=SDEL11TO5">山东11选5</a></li>  
         <li><a href="${base}/doc/numlottery?lottery=EL11TO5">江西11选5</a></li>    
         <li><a href="${base}/doc/numlottery?lottery=SSC">重庆时时彩</a></li>
      </ul>
    </div>

     <div class="mleftban">测试</div>
    <div class="mleftb1">
      <ul class="cleftmenu">
        <li><a href="${base}/doc/test">接口测试</a></li>
        <li><a href="${base}/ticket/query">查票</a></li>
      </ul>
    </div>
    <div class="mleftb1">
      <div class="k10"></div>
      <div class="top1px"> 
        值班客服电话：<br />
        主管电话：<b class="bluetel"></b><br />
      </div>
    </div>
  </div> ${body}
  <!-- left  end-->
</div>
<div class="k10"></div>
<!-- copyright begin-->
<div id="copyright">Copyright 2008-2012  All Rights Reserved<br />
  ********信息科技有限公司 客服热线： 邮箱:</div>
</body>
</html>
