<meta name="decorator" content="doc" />
<div class="mright">
    <div class="bgtitlec">发送彩票接口（101）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">101</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">提供给网站票务处理中心使用，用于接收网站票务处理中心发送的方案，该彩票应为出票机可直接出的彩票。</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"ticket":[{"orderId":"1","periodNumber":"2012087","cost":"2","multiple":"1","units":"1","playType":"0","type":"0","passType":"0","value":"01,02,03,04,05,06|01"},{"orderId":"2","periodNumber":"2012087","cost":"2","multiple":"1","units":"1","playType":"0","type":"0","passType":"0","value":"01,02,03,04,05,06|01"}],"wLotteryId":"0"}</td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">JSON格式的字符串（<font color="red">对于非必需字段，在彩种格式中没有提及到时均可置空</font>）参考下表</td>
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
	        <td class="doc_td_head_1">ticket</td>
	        <td class="doc_td_other">JSON字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩票投注JSON(具体字段参考下表)</td>
	        <td class="doc_td_other">(建议是每次最多50张彩票发送)<a href="#">查看JSON字符串格式</a></td>
      </tr>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">ticket对象JSON参数</div>
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
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other">竞彩足球，竞彩蓝球留空</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">cost</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">金额</td>
	        <td class="doc_td_other">单票最大金额限制(20000)</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">multiple</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">倍数</td>
	        <td class="doc_td_other">单票最大倍数限制(99)</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">units</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">注数</td>
	        <td class="doc_td_other">单票最大注数限制(10000)</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">playType</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">玩法</td>
	        <td class="doc_td_other">查看相应彩种说明和格式</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">type</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">投注方式</td>
	        <td class="doc_td_other">竞彩和北单有效。其它彩种填0,竞彩和北单查看相应彩种说明和格式</td>
      </tr>
       
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">passType</td>
	        <td class="doc_td_other">数字</td>
	        <td class="doc_td_other">1</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">过关方式</td>
	        <td class="doc_td_other">竞彩和北单有效。其它彩种填0,竞彩和北单查看相应彩种说明和格式</td>
      </tr>
      
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">value</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">投注内容</td>
	        <td class="doc_td_other">查看相应彩种说明和格式</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">outOrderNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">50</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">委托方方案号</td>
	        <td class="doc_td_other">一个方案号对应一个或者多个订单号(可空)</td>
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
	        <td class="doc_td_other" colspan="5">{"ticket":[{"process":"0","orderId":"21"},{"process":"0","orderId":"22"}],"processId":"0"}</td>
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
				0=成功<br/>
				2=已有此订单<br/>
				4=系统错误<br/>
				5=请求参数错误<br/>
	        </td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>