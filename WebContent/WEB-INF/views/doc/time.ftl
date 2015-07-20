<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">同步时间接口（100）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">100</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">提供给网站票务处理中心使用，用于查询票务中心服务器的时间。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2"></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">空字符串</td>
      </tr>
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">返回参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">processId</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">4</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理结果</td>
	        <td class="doc_td_other">返回处理结果代号。<a href="#" onclick="getError()">查看</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">time</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">50</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">服务器时间</td>
	        <td class="doc_td_other">时间格式yyyy-MM-dd HH:mm:ss</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">例子</td>
	        <td class="doc_td_other" colspan="5">{"time":"2012-09-06 01:56:11","processId":"0"}</td>
      </tr>
      
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>