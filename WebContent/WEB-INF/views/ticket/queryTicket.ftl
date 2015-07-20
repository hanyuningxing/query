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
	function getTicketDetail(id){
			     Miracle.getURL({
			            url: '/ticket/detail?id='+id,
			            width:500,
			            title:'彩票详情',
			            modal:false
			      });
    }
</script>

<div class="mright">
    <div class="bgtitlec">订单查询</div>
    <div class="bggrayt">
    	<a href="#" class="btuse" onclick="exportData();return false;">导出Excel</a>
    	<#--
    	<input type="checkbox" name="checkbox" id="checkbox" />
      		历史数据
    	<span class="rc1">（接单时间20130528号0点0分之前已结算、撤单的属于历史数据）</span>-->
	</div>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#ECF1F3" class="table1">
		<form id="searchForm" action="/ticket/query" method="POST">
	       	  <tr>
		        <td height="27" class="l10">
			                     起始日期
		        	<input id="startTime" type="text" name="startTime" <#if tick??&&tick.startTime??&&tick.startTime!="">value="${tick.startTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
		           	 结束时间
		        	<input id="endTime" type="text" name="endTime" <#if tick??&&tick.endTime??&&tick.endTime!="">value="${tick.endTime}"</#if> class="inputcheckbox" maxlength="10" readonly="readonly"/>
					
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
		          	 <select name="schemeState" onchange="this.form.submit();">
		            	<option value="">选择订单状态</option>
		            	<#list ztList as zType>
		                 	<option <#if tick??&&tick.schemeState?? && tick.schemeState==zType>selected="selected"</#if> value="${zType}">${zType.stateName}</option>
	                 	</#list>
		         	 </select>
		         	 <input type="hidden" name="export" id="export" value="" />
		          </td>
	       	  </tr>
	       	  <tr>
		        <td height="27"  class="l10">
			        <select id="nmType" >
			          <option <#if tick??&&tick.orderId??&&tick.orderId!="">selected="selected"</#if> value="1">订单号</option>
			          <option <#if tick??&&tick.outOrderNumber??&&tick.outOrderNumber!="">selected="selected"</#if> value="2">方案号</option>
			        </select>
		          	<input type="<#if (tick??&&tick.orderId??&&tick.orderId!="")||!tick??||!tick.outOrderNumber??||tick.outOrderNumber=="">text<#else>hidden</#if>" _name value="<#if tick??&&tick.orderId??>${tick.orderId!}</#if>" name="orderId" id="orderId" class="inputcheckbox"/>
		          	<input type="<#if tick??&&tick.outOrderNumber??&&tick.outOrderNumber!="">text<#else>hidden</#if>" _name1 value="<#if tick??&&tick.outOrderNumber??>${tick.outOrderNumber}</#if>" name="outOrderNumber" id="outOrderNumber" class="inputcheckbox" />
		        	&nbsp;
		        	<select name="orderFiled" onchange="this.form.submit();">
		          		<option  <#if tick??&&tick.orderFiled??&&tick.orderFiled="id">selected="selected"</#if> value="id">选择排序方式</option>
		          		<option <#if tick??&&tick.orderFiled??&&tick.orderFiled="createTime">selected="selected"</#if> value="createTime">投注时间</option>
		          		<option <#if tick??&&tick.orderFiled??&&tick.orderFiled="schemeCost">selected="selected"</#if> value="schemeCost">金额</option>
		            </select>
		        	&nbsp;
		        	<input type="checkbox" <#if tick??&&tick.orderDesc??&&tick.orderDesc==1>checked  value="1"<#else>value="0"</#if> name="orderDesc" id="orderDesc" class="inputcheckbox" />
		        		降序&nbsp;&nbsp;<b>期号：</b>
		        	<input name="periodNmStart" type="text" class="inputcheckbox" value="<#if tick??&&tick.periodNmStart??>${tick.periodNmStart!}</#if>" id="periodNmStart" size="15" />
		        	- 
		        	<input name="periodNmEnd" type="text" class="inputcheckbox" value="<#if tick??&&tick.periodNmEnd??>${tick.periodNmEnd!}</#if>" id="periodNmEnd" size="15" />
		        	&nbsp;<a href="#" class="btuse" name="searchBtn" id="searchBtn" onclick="submit();">查询</a></td>
		      </tr>
		</form>
		<tr>
	        <td height="27"  class="l10 rc1 char14">
	        <div class="">总销售：￥${totalSale!0}元　总订单数：${totalCount!0}张　总奖金：￥${totalPrize!0}元（可导出所有明细）</div>
	        </td>
        </tr>
	</table>
	
	<table width="790" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#ffffff" class="tb1" style="line-height:28px;">
		<tr class="tdtitle">
	        <td width="20">序</td>
	        <td width="50">订单号</td>
	        <td width="100">彩种</td>
	        <td width="60">期号</td>
	        <td width="60">彩票编号</td>
	        <td width="40">注数</td>
	        <td width="45">倍数</td>
	        <td width="60">金额</td>
	        <td width="60">奖金</td>
	        <td width="80">投注时间</td>
 
	        <td>操作</td>
        </tr>
        <#if pagination??&& (pagination.result![])?size gt 0>
	    	<#list pagination.result as data>
	    	<#if data_index%2==0><#assign trColor="trw" /><#else><#assign trColor="trgray" /></#if>
	    	<tr class="${trColor}" onmouseover="this.className='trlbro'" onmouseout="this.className='${trColor}'">
	    	  <td align="center">${data.id}</td>
		      <td align="center">${data.orderId}</td>
		      <td align="center"><#if data.lotteryType??>${data.lotteryType.lotteryName!}</#if></td>
		      <td align="center">${data.periodNumber}</td>
		      <td align="center">${data.schemeNumber}</td>
		      <td align="center">${data.units}</td>
		      <td align="center">${data.multiple}</td>
		      <td align="center">${data.schemeCost?string("##.##")}</td>
		      <td align="center"><#if data.totalPrizeAfterTax??>${data.totalPrizeAfterTax?string("##.##")}</#if></td>
		      <td align="center">${data.createTime?string("MM-dd HH:mm")}</td>
 
		      <td align="center"><a href="#" class="blue" onclick="getTicketDetail(${data.id});return false;">查看</a></td>
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