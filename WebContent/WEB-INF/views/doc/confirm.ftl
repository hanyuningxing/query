<meta name="decorator" content="doc" />
<div>
</div>
<div class="mright">
    <div class="bgtitlec">查询彩票接口（102）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">102</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">提供给网站票务处理中心使用，用于查询网站票务处理中心发送的彩票的出票状态。</td>
      </tr>
           <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">JSON格式的字符串（<font color="red">对于非必需字段，在彩种格式中没有提及到时均可置空</font>）参考下表</td>
        </tr>
         <tr class="tdgf5">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"orderId":"102,103","wLotteryId":"0"}</td>
      </tr>
        
    </table>
    <div class="k10"></div>
     <div class="bgtitlec">wParam请求参数</div>
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
	        <td class="doc_td_head_1">wLotteryId</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种ID</td>
	        <td class="doc_td_other"><a href="#" onclick="getSaleLottery();return false;">查看彩钟ID</a></td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">orderId</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">订单号字符串</td>
	        <td class="doc_td_other">最多查询50张彩票(多张彩票用,分隔.如1014,1013)</td>
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
	        <td class="doc_td_head_1">ticket</td>
	        <td class="doc_td_other">JSON</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理返回实体</td>
	        <td class="doc_td_other">参考下面例子</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">ticket例子</td>
	        <td class="doc_td_other" colspan="5">{"ticket":[{"process":"1","operateTime":"2013-09-03 17:32","awards":"{\"awardList\":[{\"jcMatchOdds\":[{\"matchKey\":\"20130903-002\",\"options\":{\"WIN\":2.8}},{\"matchKey\":\"20130903-001\",\"options\":{\"WIN\":1.4}}],\"ticketCode\":\"\",\"ticketIndex\":0}],\"schemeId\":2404}","ticketCode":"","orderId":"2404"},{"process":"1","operateTime":"2013-09-03 17:32","awards":"{\"awardList\":[{\"jcMatchOdds\":[{\"matchKey\":\"20130903-002\",\"options\":{\"WIN\":2.8}},{\"matchKey\":\"20130903-001\",\"options\":{\"WIN\":1.4}}],\"ticketCode\":\"\",\"ticketIndex\":0}],\"schemeId\":2403}","ticketCode":"","orderId":"2403"}],"processId":"0"}</td>
      </tr>
      
    </table>
    
    <div class="k10"></div>
     <div class="bgtitlec">返回参数ticket对象JSON参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="70" class="doc_td_head_1">参数</td>
	        <td width="70" class="doc_td_other">类型</td>
	        <td width="70" class="doc_td_other">长度</td>
	        <td width="100" class="doc_td_other">是否必须</td>
	        <td width="100" class="doc_td_other">名称</td>
	        <td class="doc_td_other">说明</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">orderId</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-32</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">订单号</td>
	        <td class="doc_td_other"></td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">process</td>
	         <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-2</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">处理结果</td>
	        <td class="doc_td_other" style="text-align: left">
				0=委托中(已经成功接收到彩票订单,正在出票中)<br/>
				1=出票成功（<br/>
				2=出票失败<br/>
	        </td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">operateTime</td>
	        <td class="doc_td_other">日期</td>
	        <td class="doc_td_other"></td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">接票时间</td>
	        <td class="doc_td_other"></td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">awards</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">出票sp</td>
	        <td class="doc_td_other" style="text-align: left">
				竞彩足球。竞彩篮球返回字段
	        </td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">ticketCode</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">50</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">彩票序列号</td>
	        <td class="doc_td_other"></td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>