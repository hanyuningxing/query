<meta name="decorator" content="doc" />
 <link href="${base}/styles/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
  
<div class="mright">
	<div>
		<div class="alert alert-info">
			<span>请输入要列出的记录数 </span>
			<form action="${base}/proxyIp/listFetchStatistic" method="post">
				<input type="text" name="pageSizeStr"></input>
				<input type="submit" value="确定" class="btn btn-primary"></input>
			</form>
			<#if errorMsg ??><span style="color:red">输入有误，默认列出30条记录.</span></#if>
		</div>
	</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      	<#if fetchStatisticList?? && fetchStatisticList?size gt 0>
      		<tr class="tdgraylist"><td>ip</td><td>url</td><td>status</td><td>耗时</td><td>time</td></tr>
	      	<#list  fetchStatisticList as fetch>
	      		<tr class="tdgraylist">
	      			<td>${fetch.ip}</td>
	      			<td><div style="color:blue;padding-left:3px;padding-right:3px;width:450px;height:30px; overflow:hidden;white-space:nowrap;">${fetch.url}</div></td>
	      			<td><#if fetch.status==1><span style="color:#66ccff">success</span><#else><span style="color:red">fail</span></#if></td>
	      			<td>${fetch.fetchTime}</td>
	      			<td>${fetch.createTime}</td>
	      		</tr>
	      	</#list>
      	</#if> 
    </table>
 	 
  </div>