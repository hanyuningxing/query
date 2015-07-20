<meta name="decorator" content="doc" />
<script type="text/javascript" src="${base}/scripts/common/dateUtil.js"></script>
<script type="text/javascript">
	function submit(){
		var formObj = $('#searchForm');
		formObj.submit();
	}
	
	 $(function() {
	  //$("#orderId").attr("type","text");
	  //$("#outOrderNumber").attr("type","hidden");
		  
	   $("#startTime").datetimepicker({
	        currentText: '现在',
			closeText: '完成',
			timeText: '小时:分钟',
			hourText: '  小时',
			minuteText: '  分钟',
	        dateFormat: 'yy-mm-dd',
		    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    dayNamesMin: ['日','一','二','三','四','五','六'],
			defaultDate: "+1w",
			changeMonth: true,
			changeYear: true,
		  });
	    $("#endTime").datetimepicker({
	        currentText: '现在',
			closeText: '完成',
			timeText: '小时:分钟',
			hourText: '  小时',
			minuteText: '  分钟',
	        dateFormat: 'yy-mm-dd',
		    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    dayNamesMin: ['日','一','二','三','四','五','六'],
			defaultDate: "+1w",
			changeMonth: true,
			changeYear: true,
		  });
		  
		  $("#nmType").change(function(){
		  	var type = $("#nmType").val();
		  	if(type == "1"){
		  		$("#outOrderNumber").attr("type","hidden");
		  		$("#outOrderNumber").val("");
		  		$("#orderId").attr("type","text");
		  	}else if(type == "2"){
		  		$("#orderId").attr("type","hidden");
		  		$("#orderId").val("");
		  		$("#outOrderNumber").attr("type","text");
		  	}
		  });
		  
		  $("#orderDesc").bind("click",function(){
		  		if($("#orderDesc").prop('checked')){
		  			$("#orderDesc").val(1);
		  		}else{
		  			$("#orderDesc").val(0);
		  		}
		  		submit();
		  });
		  
	});
	
	function exportData(){
		$("#export").val(1);
		submit();
	}
	
	function timeUpdate(flag){
		switch(flag){
		case 1://今天
			$("#startTime").val(formatDate(now)+" 00:00:00");
			$("#endTime").val(formatDate(now)+" 23:59:59");
			submit();
			break;
		case 2://昨天
			var yestoday=new Date(nowYear, nowMonth, nowDay - 1);
			$("#startTime").val(formatDate(yestoday)+" 00:00:00");
			$("#endTime").val(formatDate(yestoday)+" 23:59:59");
			submit();
			break;
		case 3://本周
			$("#startTime").val(getWeekStartDate()+" 00:00:00");
			$("#endTime").val(getWeekEndDate()+" 23:59:59");
			submit();
			break;
		case 4://上周
			$("#startTime").val(getLastWeekStartDate()+" 00:00:00");
			$("#endTime").val(getLastWeekEndDate()+" 23:59:59");
			submit();
			break;
		case 5://本月
			$("#startTime").val(getMonthStartDate()+" 00:00:00");
			$("#endTime").val(getMonthEndDate()+" 23:59:59");
			submit();
			break;
		case 6://下月
			$("#startTime").val(getLastMonthStartDate()+" 00:00:00");
			$("#endTime").val(getLastMonthEndDate()+" 23:59:59");
			submit();
			break;
		}
	}
</script>

<div class="mright">
    <div class="bgtitlec">出票统计</div>
    <div class="bggrayt">
    	<a href="#" class="btuse" onclick="exportData();return false;">导出Excel</a>
    	<#--
    	<input type="checkbox" name="checkbox" id="checkbox" />
      		历史数据
    	<span class="rc1">（接单时间20130528号0点0分之前已结算、撤单的属于历史数据）</span>-->
	</div>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#ECF1F3" class="table1">
		<form id="searchForm" action="/ticket/countquery" method="POST">
	       	  <tr>
		        <td height="27" class="l10">
			        接票时间：起始
		        	<input id="startTime" type="text" name="startTime" <#if tick??&&tick.startTime??&&tick.startTime!="">value="${tick.startTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
		           	 结束
		        	<input id="endTime" type="text" name="endTime" <#if tick??&&tick.endTime??&&tick.endTime!="">value="${tick.endTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
					
		         	 <input type="hidden" name="export" id="export" value="" />
		          </td>
	       	  </tr>
	       	  <tr>
		        <td height="27"  class="l10">
		        <select name="schemeState" onchange="this.form.submit();">
	            	<option value="">选择订单状态</option>
	            	<#list ztList as zType>
	                 	<option <#if tick??&&tick.schemeState?? && tick.schemeState==zType>selected="selected"</#if> value="${zType}">${zType.stateName}</option>
                 	</#list>
	         	 </select>
		          <select name="lotteryType" onchange="this.form.submit();">
	                 <option value="">选择彩种</option>
	                 <#list czList as lType>
		                 <option <#if tick??&&tick.lotteryType?? && tick.lotteryType==lType>selected="selected"</#if> value="${lType}">${lType.lotteryName}</option>
                 	 </#list>
	             </select>
		          <select name="betType" size="1" onchange="this.form.submit();">
	            	<option value="">选择玩法</option>
	            	<#if playTypeItems??>
	            	<#list playTypeItems as item>
	            		<option value="${item.value}" <#if tick??&&tick.betType==item.value?string>selected</#if> >${item.text}</option>
	            	</#list>
	            	</#if>
	          	 </select>
		          &nbsp;&nbsp;期次：
		          <input name="periodNum" type="text" class="inputcheckbox" id="textfield3" size="15" value="<#if tick??&&tick.periodNum??>${tick.periodNum}</#if>"/>
		         &nbsp;<a href="#" class="btuse" name="searchBtn" id="searchBtn" onclick="submit();">查询</a></td>
		      </tr>
		      <tr>
		        <td height="30" class="left5"><a href="#" onclick="timeUpdate(1)" class="btuse">今天</a> <a href="#" onclick="timeUpdate(2)" class="btuse">昨天</a> <a href="#" onclick="timeUpdate(3)" class="btuse">本周</a> <a href="#" onclick="timeUpdate(4)" class="btuse">上周</a> <a href="#" onclick="timeUpdate(5)" class="btuse">本月</a> <a href="#" onclick="timeUpdate(6)" class="btuse">上月</a> </td>
		      </tr>
		</form>
	</table>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#ffffff" class="tb1" style="line-height:28px;">
		<tr class="tdtitle">
	        <td>彩种</td>
	        <td>购彩总额</td>
	        <td>总票数</td>
	        <td>税前奖金</td>
	        <td>税后奖金</td>
	        <td>加奖</td>
        </tr>
        <#if dataList??&& dataList?size gt 0>
        <#assign totalCost = 0/>
        <#assign totalCount = 0/>
        <#assign totalPrize = 0/>
        <#assign totalPrizeAfterTax = 0/>
        <#assign addPrize = 0/>
	    <#list dataList as data>
	    	<#if data_index%2==0><#assign trColor="trw" /><#else><#assign trColor="trgray" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trlbro'" onmouseout="this.className='${trColor}'">
	    	  <td align="center">${data.lotteryType.lotteryName}</td>
		      <td align="center">${data.totalCost!0}</td>
		      <td align="center">${data.totalCount!0}</td>
		      <td align="center">${(data.totalPrize!0)?string('0.##')}</td>
		      <td align="center">${(data.totalPrizeAfterTax!0)?string('0.##')}</td>
		      <td align="center">${(data.addPrize!0)?string('0.##')}</td>
		        <#assign totalCost = totalCost+data.totalCost!0/>
		        <#assign totalCount = totalCount+data.totalCount!0/>
		        <#assign totalPrize = totalPrize+data.totalPrize!0/>
		        <#assign totalPrizeAfterTax = totalPrizeAfterTax+data.totalPrizeAfterTax!0/>
		        <#assign addPrize = addPrize+data.addPrize!0/>
			</tr>
    	</#list>
    	
    	  <tr class="${trColor}" onmouseover="this.className='trlbro'" onmouseout="this.className='${trColor}'">
	    	  <td align="center"><#if resultMoney??>(余额:${(resultMoney!0)?string('0.##')})</#if>合计</td>
		      <td align="center">${totalCost}</td>
		      <td align="center">${totalCount!0}</td>
		      <td align="center">${(totalPrize!0)?string('0.##')}</td>
		      <td align="center">${(totalPrizeAfterTax!0)?string('0.##')}</td>
		      <td align="center">${(addPrize!0)?string('0.##')}</td>
			</tr>
	    <#else> 
		    <tr>
		      <td class="trw" align="center" colspan="13">无记录</td>
		    </tr>
	    </#if>
	</table>
	<#if pagination??&& (pagination.result![])?size gt 0>
	<#import "/WEB-INF/macro/pagination.ftl" as b />
	<@b.page />
	</#if>
</div>