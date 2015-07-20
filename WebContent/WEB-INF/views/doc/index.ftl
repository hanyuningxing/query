<meta name="decorator" content="doc" />
<script>
      
</script>
<div class="mright">
    <div class="bgtitlec">服务约定</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">编码</td>
        <td class="doc_title_td2">UTF-8(服务中涉及的字符编码统一用<font color="red">UTF-8</font>)</td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">协议</td>
        <td class="doc_title_td2">HTTP</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">提交方式</td>
        <td class="doc_title_td2">POST</td>
      </tr>
       <tr class="tdgf5" >
        <td class="doc_title_td1">返回格式</td>
        <td class="doc_title_td2">JSON</td>
      </tr>
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">请求参数</div>
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
	        <td class="doc_td_head_1">wAction</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">4</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">业务请求ID</td>
	        <td class="doc_td_other">参考左侧菜单《接口相关接口》</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">wAgent</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">6</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">平台ID</td>
	        <td class="doc_td_other"><a href="#">查看平台ID</a></td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">wParam</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">wParam</td>
	        <td class="doc_td_other">JSON字符串</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">wSign</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">32</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">请求密钥</td>
	        <td class="doc_td_other">加密方式：wAction + wParam + wAgent +平台密码 <a href="#">查看平台密码</a></td>
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
	        <td class="doc_td_head_1">object</td>
	        <td class="doc_td_other">JSON</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理返回实体</td>
	        <td class="doc_td_other"></td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>