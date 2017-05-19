<meta name="decorator" content="doc" />
 <style>
 	.red{color:red;}
 </style>
<div class="mright">
    <div class="bgtitlec">赛事选择</div>
    <table name="table0" width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      	<#if projectlist?? && projectlist?size gt 0>
      		<tr class="tdtitle">
	      			<td  class="doc_td_head_1">热门</td>
	      			<td  class="doc_td_head_1">用户</td>
	      			<td class="doc_td_other">内容</td>
	      			<td class="doc_td_other">金额</td>
	      			<td class="doc_td_other">结束时间</td>
	      	</tr>  
	      	<#list  projectlist as project>
	      	   <#if (project_index+1)%2==0><#assign classStr='tdwhitelist' /><#else><#assign classStr='tdgraylist' /></#if>
	      	   <tr class="${classStr}" onmouseover="this.className='trhover'" onmouseout="this.className='${classStr}'" >
	      			<td class="doc_td_other red"><#if project.hotPerson>☆</#if><#if project.wonNum??>${project.wonNum}</#if></td>
	      			<td class="doc_td_other" title="${project.projectId}"><#if project.nickName??>${project.nickName}</#if></td>
	      			<td class="doc_td_other" style="word-break:break-all;"><#if project.code??>${project.code}</#if></td>
	      			<td class="doc_td_other"><#if project.moeny??>${project.moeny}</#if></td>
	      			<td class="doc_td_other"><#if project.endTime??>${project.endTime?string("yyyy-MM-dd HH:mm")}</#if></td>
	      	   </tr>
	      	</#list>
      	</#if>    
    </table>
  </div>