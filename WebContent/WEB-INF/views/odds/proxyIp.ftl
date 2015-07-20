<meta name="decorator" content="doc" />
 <link href="${base}/styles/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
 <script>
 		function checkProxy(ip){
 			var input= document.getElementById("check_source_url").value;
 			var url =  window.BASESITE+"/proxyIp/check?ip="+ip; 
 			if(input!=''){
 				url =  window.BASESITE+"/proxyIp/check?ip="+ip+"&myurl="+input; 
 			}	
 			$.ajax({
 				type:'get',
 				url:url,
 				dataType:"json", 
 				success : function(json){
 				 	alert(json); 
 				 }  
 			});
 		}
 </script>
<div class="mright">
	<div>
		<div class="alert alert-info">
			<span>请输入需要测试的URL地址..有默认值,可不填</span><br><input id="check_source_url" type="text">
		</div>
	</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      	<#if proxyIpList?? && proxyIpList?size gt 0>
      		<tr class="tdgraylist"><td>ip</td><td>端口</td><td>崩坏次数</td><td></td></tr>
	      	<#list  proxyIpList as proxyIp>
	      		<tr class="tdgraylist">
	      			<td><a onclick="checkProxy('${proxyIp.ip}:${proxyIp.port}');return false;">${proxyIp.ip}</a></td>
	      			<td>${proxyIp.port}</td>
	      			<td><#if proxyIp.count??>${proxyIp.count}</#if></td>
	      			<td><a href="${base}/proxyIp/disable?id=${proxyIp.id}">置为失效</a></td>
	      		</tr>
	      	</#list>
      	</#if>
       
    </table>
 	<#if failList?? &&failList?size gt 0>
 		<div style="margin:10px;">
 		 <div class="alert alert-info">失败的ip</div>
 		  <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
		 	  	<#list  failList as fail>
			      		<tr class="tdgraylist">
			      			<td>${fail_index}</td>
			      			<td>${fail}</td>
			      		</tr>
			      </#list>
		      </table>
	      </div>
 	</#if>
   	<div style="margin-top:30px;">
   		 <div class="alert alert-info">上传ip文件的txt
   		<form enctype="multipart/form-data"   method="post" action="${base}/proxyIp/uploadFile">
	   		<table class="table">
		   		 
		   		 <tr><td>txt</td><td><input type="file" name="file" style="width:90%" title="上传txt"/></td></tr>
		   		 <tr><td></td><td><input type="submit"  value="提交" class="btn btn-primary"></td></tr>
	   		 </table>
   		  </form>
   		 </div>
   	</div>
   		<#if error??><div class="alert alert-error">${error}</div></#if>
  </div>