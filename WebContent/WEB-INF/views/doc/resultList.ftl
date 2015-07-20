<meta name="decorator" content="doc" />
<div>
</div>
<div class="mright">
    <div class="bgtitlec">开奖号码查询（109）</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><font color="red">109</font></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">作用</td>
        <td class="doc_title_td2">通过本接口查询指定彩种指定期号的开奖号码。如果不指定期号，则返回销售平台最近开奖期号的开奖号码。</td>
      </tr>
           <tr class="tdwhitelistnotc">
        <td  class="doc_title_td1">wParam</td>
        <td class="doc_title_td2">JSON格式的字符串（<font color="red">对于非必需字段，在彩种格式中没有提及到时均可置空</font>）参考下表</td>
        </tr>
         <tr class="tdgf5">
        <td  class="doc_title_td1">wParam例子</td>
        <td class="doc_title_td2">{"periodNumber":"2014081211","wLotteryId":"0"}或{"periodNumber":"","wLotteryId":"0"}</td>
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
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号字符串</td>
	        <td class="doc_td_other">如果为空则查找最近一期</td>
      </tr>
    </table>
     <div class="k10"></div>
     <div class="bgtitlec">返回参数</div>
    <table width="790" border="0" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
        <tr class="tdtitle">
	        <td width="80" class="doc_td_head_1">参数</td>
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
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">errorMsg</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">N</font></td>
	        <td class="doc_td_other">出错原因</td>
	        <td class="doc_td_other">返回出错原因</td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">resultList</td>
	        <td class="doc_td_other">JSON</td>
	        <td class="doc_td_other">500行</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">开奖号码列表</td>
	        <td class="doc_td_other">参考下面例子</td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">resultList例子</td>
	        <td class="doc_td_other" colspan="5"   style="text-align: left;word-break:break-all">{"resultList":[{"lotteryType":"SSQ","periodId":1,"periodNumber":"2012075","periodTitle":"","prizeTime":"2012-06-28 19:50:00","result":"11,14,9,5,16,15,11"}]}</td>
      </tr>
      
    </table>
    
    <div class="k10"></div>
     <div class="bgtitlec">返回参数resultList对象JSON参数</div>
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
	        <td class="doc_td_head_1">lotteryType</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">1-6</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种</td>
	        <td class="doc_td_other"><a href="${base}/doc/lotterytype">附录-彩种编号-lotteryType</a></td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">periodNumber</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other" style="text-align: left">

	        </td>
      </tr>
      <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	       <td class="doc_td_head_1">periodTitle</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">彩种简单描述</td>
	        <td class="doc_td_other">
				比如双色球：“每二，四，六开奖”
	        </td>
      </tr>
     <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">prizeTime</td>
	         <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">6-10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">官方开奖时间</td>
	        <td class="doc_td_other" style="text-align: left">
				
	        </td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">periodNumber</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">10</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期号</td>
	        <td class="doc_td_other"  style="text-align: left"></td>
      </tr>
      <tr class="tdwhitelist" onmouseover="this.className='trhover'" onmouseout="this.className='tdwhitelist'" >
	        <td class="doc_td_head_1">periodId</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">4-5</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">期ID</td>
	        <td class="doc_td_other"  style="text-align: left"></td>
      </tr>
       <tr class="tdgraylist" onmouseover="this.className='trhover'" onmouseout="this.className='tdgraylist'" >
	        <td class="doc_td_head_1">result</td>
	        <td class="doc_td_other">字符串</td>
	        <td class="doc_td_other">500</td>
	        <td class="doc_td_other"><font color="red">Y</font></td>
	        <td class="doc_td_other">开奖号码</td>
	        <td class="doc_td_other"><a href="${base}/dco/resultFormat">参考附录，开奖号码格式</a></td>
      </tr>
    </table>
    <!-- right table  end-->
    <!-- pagelist  end-->
  </div>