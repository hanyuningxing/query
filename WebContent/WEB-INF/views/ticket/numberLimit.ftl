<meta name="decorator" content="doc" />
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
</script>

<div class="mright">
    <div class="bgtitlec">订单查询</div>
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#ECF1F3" class="table1">
		<form id="searchForm" action="/ticket/limit" method="POST">
	       	  <tr>
		        <td height="27"  class="l10">
			        <select name="lotteryType" onchange="this.form.submit();">
		                 <option value="">选择彩种</option>
		                 <#list czList as lType>
			                 <option <#if lotteryType?? && lotteryType==lType>selected="selected"</#if> value="${lType}">${lType.lotteryName}</option>
	                 	 </#list>
		             </select>
		        	&nbsp;期号：
		        	<input name="periodNumber" type="text" class="inputcheckbox" value="<#if periodNumber??>${periodNumber!}</#if>" id="periodNumber" size="15" />
		        	&nbsp;<a href="#" class="btuse" name="searchBtn" id="searchBtn" onclick="submit();">查询</a></td>
		      </tr>
		</form>
	</table>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#ffffff" class="tb1" style="line-height:28px;">
		<tr class="tdtitle">
	        <td width="100">编号</td>
	        <td width="110">期号</td>
	        <td width="150">彩种</td>
	        <td>限号内容</td>
	        <td width="100">剩余注数</td>
	        <td width="120">生成时间</td>
        </tr>
        <#if pagination??&& (pagination.result![])?size gt 0>
	    	<#list pagination.result as data>
	    	<#if data_index%2==0><#assign trColor="trw" /><#else><#assign trColor="trgray" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trlbro'" onmouseout="this.className='${trColor}'">
	    	  <td align="center">${data.id}</td>
		      <td align="center">${data.periodNumber}</td>
		      <td align="center"><#if data.lotteryType??>${data.lotteryType.lotteryName!}</#if></td>
		      <td align="center">${data.content!}</td>
		      <td align="center">${data.remainUnits!0}</td>
		      <td align="center">${data.createTime?string("MM-dd HH:mm")}</td>
		      
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