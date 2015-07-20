
<#macro page paramMap={}>
	<#local ajaxContainer=paramMap['ajaxContainer']!"" />
	<#local pageUrl=(paramMap['pageUrl']!request.requestURI[(request.contextPath?length)..((request.requestURI?length-1))])+"?" />	
	<#local showNum=paramMap['showNum']!7 />
	<#if showNum lt 3><#local showNum=7 /></#if>
	
	<#local excludes=["pageNo","pagination.pageSize"]+paramMap['excludes']![] />
	
	<#if paramMap['params']??>
		<#local params=paramMap['params'] />
	<#else>
		<#local params=request.getParameterMap()!{}/>
	</#if>
	<#list params?keys as key>
		
		<#local canInclude=true />	
		<#list excludes as item >
			<#if key == item>
				<#local canInclude=false />	
				<#break />
			</#if>
		</#list>
		<#if canInclude>
			<#local paramValue=params[key]!"" />
			<#if paramValue?is_collection || paramValue?is_sequence>
				<#list paramValue as v>
					<#local pageUrl=pageUrl+key+"="+v+"&" />
				</#list>
				<#--<#return/>-->
			<#elseif paramValue?is_string&&paramValue != "">
				<#local pageUrl=pageUrl+key+"="+paramValue?string+"&" />
			</#if>
		</#if>
	</#list>
	
	<#local totalCount=pagination.totalCount!0 />
	<#if totalCount < 0>
		<#local totalCount=0 />
	</#if>
	<#local pageNo=pagination.pageNo!1 />
	<#if pageNo <= 0>
		<#local pageNo=1 />
	</#if>
	<#local totalPages=pagination.totalPages!1 />
	<#if totalPages <= 0>
		<#local totalPages=1 />
	</#if>
	
	<#if pageNo gt 1>
		<#local prevPageNo=(pageNo-1) />
	<#else>
		<#local prevPageNo=1 />
	</#if>
	
	<#if pageNo == totalPages>
		<#local nextPageNo=pageNo />
	<#else>
		<#local nextPageNo=pageNo+1 />
	</#if>
	
	<script type="text/javascript">
		function fn_turnPage(obj_go){
			if(obj_go.id&&obj_go.id=="turnPage"){
				var obj = document.getElementById("pagination_pageNo");
				var pageNo = 1;
				if(obj != null && /^\d/.test(obj.value)){
					pageNo = obj.value;
					if(pageNo > ${totalPages}){
						pageNo = ${totalPages};
					} 
				}
				obj_go.href += "pageNo="+pageNo;
				<#if !(ajaxContainer??) || ajaxContainer == "">
					window.location.href = obj_go.href;
					return false;
				</#if>
			}
			
			<#if ajaxContainer?? && ajaxContainer != "">
				$('#extra-data-container').load(obj_go.href);
				return false;
			<#else>
				return true;
			</#if>
		}
	</script>	
	
	<div class="cb pagelist" align="center">
		<#--<a href="<@c.url value='${pageUrl+"pageNo=1"}' />" onclick="return fn_turnPage(this);">首页</a>
		<a href="<@c.url value='${pageUrl+"pageNo="+prevPageNo}' />" onclick="return fn_turnPage(this);">上一页</a>
		-->
		<#if totalPages <= showNum+2>
			<#list 1..totalPages as index>
				<a class="<#if index==pageNo>nowpage<#else>pagenum</#if>" href="<@c.url value='${pageUrl+"pageNo="+index}' />" onclick="return fn_turnPage(this);">${index}</a>
			</#list>
		<#else>
			<#-- ************* -->
			<#local temp = pageNo-(showNum-showNum%2)/2 />
			<#local startIndex = 1 />
			<#if temp gt 1>
				<#local startIndex=temp />
			</#if>
			<#local endIndex=0 />
			<#local temp = startIndex+(showNum-1) />
			<#if startIndex+(showNum-1) lt totalPages>
				<#local endIndex=temp />
			<#else>
				<#local endIndex=totalPages />
				<#local temp = totalPages-(showNum-1) />
				<#if temp gt 0>
					<#local startIndex=temp />
				<#else>
					<#local startIndex=1 />
				</#if>
			</#if>
			<#if startIndex == 1>
				<#local endIndex=endIndex+1 />
			</#if>
			<#if endIndex == totalPages>
				<#local startIndex=startIndex-1 />
			</#if>
			
			<#if startIndex gt 1>
				<a class="<#if 1==pageNo>nowpage<#else>pagenum</#if>" href="<@c.url value='${pageUrl+"pageNo=1"}' />" onclick="return fn_turnPage(this);">1</a>
			</#if>
			<#if startIndex gt 2 >
				<#local temp=0 />
				<#if startIndex gt showNum>
					<#local temp=totalPages-showNum />
				<#else>
					<#local temp=(startIndex+startIndex%2)/2 />
				</#if>
				<a class="pagenum" href="<@c.url value='${pageUrl+"pageNo="+temp}' />" onclick="return fn_turnPage(this);">...</a>
			</#if>
			
			<#list startIndex..endIndex as index>
				<a class="<#if index==pageNo>nowpage<#else>pagenum</#if>" href="<@c.url value='${pageUrl+"pageNo="+index}' />" onclick="return fn_turnPage(this);">${index}</a> 
			</#list>
			
			
			<#if endIndex lt totalPages-1 >
				<#local temp=totalPages />
				<#if totalPages-endIndex gt showNum>
					<#local temp=pageNo+showNum />
				<#else>
					<#local temp=totalPages-endIndex />
					<#local temp=endIndex+(temp-temp%2)/2 />
				</#if>
				<a class="pagenum" href="<@c.url value='${pageUrl+"pageNo="+temp}' />" onclick="return fn_turnPage(this);">...</a> 
			</#if>
			<#if endIndex lt totalPages >
				<a class="pagenum" href="<@c.url value='${pageUrl+"pageNo="+totalPages}' />" onclick="return fn_turnPage(this);">${totalPages}</a> 
			</#if>
			
		</#if>
		，转到<input style="height:12px;" size="4" id="pagination_pageNo" name="pagination_pageNo" />页 
        <a id="turnPage" class="pagenum" href="<@c.url value=pageUrl />" onclick="return fn_turnPage(this);">GO</a>
	 	
	</div>
</#macro>   