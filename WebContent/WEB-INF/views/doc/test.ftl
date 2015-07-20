<meta name="decorator" content="doc" />
<script>
      function getMD5(){
        var wAction = $('input[id=wAction]').val();
        var wAgent = $('input[id=wAgent]').val();
        var wParam = $('textarea[id=wParam]').val();
        var wKey = $('input[id=wKey]').val();
        Miracle.ajaxData({
            url: '/test/md5',
            data:{
               md5:wAction+wParam+wAgent+wKey
            },
            callBack:function(jsonObj){
               
               $('input[id=wSign]').val(jsonObj.md5);
            }
        });
      }
      function getError(){
        Miracle.getURL({
            url: '/doc/error',
            width:300,
            title:'处理结果',
            modal:false
        });
      }
</script>
<div class="mright">
    <div class="bgtitlec">MD5校验</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">MD5校验</td>
        <td class="doc_title_td2">验证本地的MD5和服务器MD5是否一致</td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">要校验的字符串</td>
        <td class="doc_title_td2"><input type="text" id="md5" class="ui-autocomplete-input"></input></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td class="doc_title_td1">测试</td>
        <td class="doc_title_td2"><button id="button" onclick="Miracle.ajaxData({
            url: '/test/md5',
            data:{
               md5:$('input[id=md5]').val()
            },
            callBack:function(jsonObj){
               Miracle.alert('加密结果:<br/>'+jsonObj.md5);
            },
            submitEl:'button'
        });">测试MD5</button></td>
    </table>
      <div class="bgtitlec">接口调用(参数参考)</div>
    <table width="790" border="0" align="center" cellpadding="0" cellspacing="0" class="tb1" style="line-height:28px;">
      <tr class="tdgf5" >
        <td class="doc_title_td1">wAction</td>
        <td class="doc_title_td2"><input type="text" id="wAction" value="101" onkeyup="getMD5();return false;" class="ui-autocomplete-input"   style="width:230px"/></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">商家密钥</td>
        <td class="doc_title_td2"><input type="text" id="wKey"  value="${wKey!}" onkeyup="getMD5();return false;" class="ui-autocomplete-input" style="width:230px"/></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">wAgent</td>
        <td class="doc_title_td2"><input type="text" id="wAgent"  value="${wAgent!}" onkeyup="getMD5();return false;" class="ui-autocomplete-input"   style="width:230px"/></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td width="100" class="doc_title_td1">wParam</td>
        <td class="doc_title_td2"><textarea id="wParam" onkeyup="getMD5();return false;" class="ui-autocomplete-input" style="width:530px;height:200px"></textarea></td>
      </tr>
      <tr class="tdgf5" >
        <td class="doc_title_td1">wSign</td>
        <td class="doc_title_td2"><input type="text" id="wSign" class="ui-autocomplete-input"  style="width:230px"/></td>
      </tr>
      <tr class="tdwhitelistnotc">
        <td class="doc_title_td1">测试接口</td>
        <td class="doc_title_td2"><button id="button" onclick="Miracle.ajaxData({
            url: '/test/action',
            data:{
               wAction:$('input[id=wAction]').val(),
               wAgent:$('input[id=wAgent]').val(),
               wParam:$('textarea[id=wParam]').val(),
               wSign:$('input[id=wSign]').val()
            },
            callBack:function(jsonObj){
               Miracle.alert('返回结果:<br/>'+jsonObj.msg);
            },
            submitEl:'button'
        });">测试接口</button></td>
    </table>
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
	        <td class="doc_td_other"><a href="#">查看业务ID</a></td>
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
	        <td class="doc_td_other">JSON字符串<a href="#">查看JSON字符串格式</a></td>
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