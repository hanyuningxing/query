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
			secondText: '    秒',
	        timeFormat: 'HH:mm:ss',
	        dateFormat: 'yy-mm-dd',
		    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    dayNamesMin: ['日','一','二','三','四','五','六'],
			defaultDate: +1,
			changeMonth: true,
			changeYear: true,
			showSecond: true,
		  });
	    $("#endTime").datetimepicker({
	        currentText: '现在',
			closeText: '完成',
			timeText: '小时:分钟',
			hourText: '  小时',
			minuteText: '  分钟',
			secondText: '    秒',
	        timeFormat: 'HH:mm:ss',
	        dateFormat: 'yy-mm-dd',
		    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    dayNamesMin: ['日','一','二','三','四','五','六'],
			defaultDate: +1,
			changeMonth: true,
			changeYear: true,
			showSecond: true,
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
    <div class="bgtitlec">资金明细</div>
    <div class="bggrayt">
    	<a href="#" class="btuse" onclick="exportData();return false;">导出Excel</a>
    	<#--
    	<input type="checkbox" name="checkbox" id="checkbox" />
      		历史数据
    	<span class="rc1">（接单时间20130528号0点0分之前已结算、撤单的属于历史数据）</span>-->
	</div>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#ECF1F3" class="table1">
		<form id="searchForm" action="/user/fundcount" method="POST">
	       	  <tr>
		        <td height="27" class="l10">
			        起始日期
		        	<input id="startTime" type="text" name="startTime" <#if query??&&query.startTime??&&query.startTime!="">value="${query.startTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
		           	结束日期
		        	<input id="endTime" type="text" name="endTime" <#if query??&&query.endTime??&&query.endTime!="">value="${query.endTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
					
		         	 <input type="hidden" name="export" id="export" value="" />
		          </td>
	       	  </tr>
	       	  <tr>
		        <td height="36" class="l10"><strong>交易类型</strong>
		          <select name="fundType" size="1"  onchange="this.form.submit();">
		            <option value="">选择交易类型</option>
		            <#list fundTypeList as type>
		                 <option <#if query??&&query.fundType?? && query.fundType==type>selected="selected"</#if> value="${type}">${type.typeName}</option>
                 	 </#list>
		          </select>          
		          &nbsp;
		          <select name="fundMode" size="1" onchange="this.form.submit();">
		            <option value="">资金类型</option>
		            <#list fundModeList as type>
		                 <option <#if query??&&query.fundMode?? && query.fundMode==type>selected="selected"</#if> value="${type}">${type.typeName}</option>
                 	 </#list>
		          </select>
		          备注
		          ：<input name="remark" type="text" value="<#if query??>${query.remark!}</#if>" class="inputcheckbox" id="textfield3" size="15" />
		                              
				<a href="#" class="btuse" onclick="submit();">查询</a></td>
		      </tr>

		      <tr>
		        <td height="30" class="left5"><a href="#" onclick="timeUpdate(1)" class="btuse">今天</a> <a href="#" onclick="timeUpdate(2)" class="btuse">昨天</a> <a href="#" onclick="timeUpdate(3)" class="btuse">本周</a> <a href="#" onclick="timeUpdate(4)" class="btuse">上周</a> <a href="#" onclick="timeUpdate(5)" class="btuse">本月</a> <a href="#" onclick="timeUpdate(6)" class="btuse">上月</a> </td>
		      </tr>
		</form>
	</table>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#ffffff" class="tb1" style="line-height:28px;">
		<tr class="tdtitle">
	        <td>交易类型</td>
	        <td>收入金额</td>
	        <td>支出金额</td>
	        <td>交易数目</td>
        </tr>
        <#if dataList??&& dataList?size gt 0>
	    	<#list dataList as data>
	    	<#if data_index%2==0><#assign trColor="trw" /><#else><#assign trColor="trgray" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trlbro'" onmouseout="this.className='${trColor}'">
	    	  <td align="center">${data.type.typeName}</td>
		      <td align="center">${(data.moneyIn!0)?string('0.##')}</td>
		      <td align="center">${(data.moneyOut!0)?string('0.##')}</td>
		      <td align="center">${data.fundCount!0}</td>
			</tr>
    	</#list>
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