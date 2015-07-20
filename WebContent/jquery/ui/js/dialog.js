var Miracle = {};
/**
 * 设置Cookie
 * @param {Object} o javascript对象，该对象可以包含以下属性：<ul>
 * <li><b>name</b> {String} cookie名称</li>
 * <li><b>value</b> {String} cookie值</li>
 * <li><b>expires</b> {Number} (可选)，cookie失效时间，单位秒</li>
 * <li><b>path</b>	{String} (可选)，cookie路径</li>
 * <li><b>domain</b> {String} (可选)，cookie域</li>
 * <li><b>secure</b> {Boolean}(可选)，我也不清楚这个有什么用</li>
 * </ul>
 */
Miracle.alert = function(message){
	if ($("#dialogalert").length == 0) {
        $("body").append('<div id="dialogalert"></div>');
        $("#dialogalert").dialog({
            autoOpen: false,
            title: '提示',
            modal: true,
            resizable:false,
            overlay: {
                opacity: 0.5,
                background: "black"
            },
            buttons: {
                "确定": function(){
                    $(this).dialog("close");
                }
            }
        });
    }

	$("#dialogalert").html(message);
	$("#dialogalert").dialog("open");
};
Miracle.confirm = function(message, callback){
    if ($("#dialogconfirm").length == 0) {
        $("body").append('<div id="dialogconfirm"></div>');
        $("#dialogconfirm").dialog({
            autoOpen: false,
            title: '消息框',
            modal: true,
            resizable:false,
            buttons: {
                "确定": function(){
                	if (callback != null && typeof callback == 'function') {
                		callback();
        			}
                    $(this).dialog("close");
                },
                "取消": function(){
                    $(this).dialog("close");
                }
            }
        });
    }
    $("#dialogconfirm").html(message);
    $("#dialogconfirm").dialog("open");    
};
Miracle.getURL = function(o){
    if ($("#dialogurl").length == 0) {  
        $("body").append('<div id="dialogurl"></div>');
        $("#dialogurl").dialog({
            autoOpen: false,
            title: '提示',
            modal: true
        });
        if(o.width)$("#dialogurl").dialog('option', 'width', o.width);
        if(o.height)$("#dialogurl").dialog('option', 'height', o.height);
		if(o.title)$("#dialogurl").dialog('option', 'title', o.title);
		if(null!=o.modal)$("#dialogurl").dialog('option', 'modal', o.modal); 		
    }
    if(o.url){
		   $.ajax({
					type : 'GET',
					cache : false,
					url : window.BASESITE + o.url,
					success : function(htmlValue) {
						 $("#dialogurl").html(htmlValue);
						 $("#dialogurl").dialog('open');//设置为‘open’时将显示对话框  	
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
					}
		   });
	}
};
Miracle.getData = function(o){
    if(o.url){
		   $.ajax({
					type : 'GET',
					cache : false,
					url : window.BASESITE + o.url,
					success : function(jsonObj) {
						if (o.callBack != null && typeof o.callBack == 'function') {
							o.callBack(jsonObj);
						}else{
							Miracle.alert("操作成功");
						}	
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
					}
		   });
	}
};
Miracle.ajaxForm = function(o){
    var form = $("#"+o.form);
    var submitEl = $("#"+o.submitEl);
    var submitElInnerHTML = submitEl.innerHTML;
    var submitParent=submitEl.parent();
    var options = {
			type : 'POST',
			dataType:'json',
			cache : false,
			data : {
				ajax : 'true'
			},
			success : function(jsonObj) {
				if (jsonObj.success == true) {
					if (o.callBack != null && typeof o.callBack === 'function') {
						o.callBack(jsonObj);
					}else{
						Miracle.alert("操作成功");
					}
				} else {
					
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('提交请求失败.');
				refreshRequestToken();
			},
			beforeSend : function(XMLHttpRequest) {
				submitEl.style.display = 'none';
				document.getElementById('span_createForm_waiting').style.display = '';
			},
			complete : function(XMLHttpRequest, textStatus) {
				document.getElementById('span_createForm_submit').style.display = '';
				document.getElementById('span_createForm_waiting').style.display = 'none';
			}
		};
	$(form).ajaxSubmit(options);
    
};
Miracle.ajaxData = function(o){
	var submitParent = null;
	var submitElInnerHTML = null;
	if(o.submitEl){
		 var submitEl = $("#"+o.submitEl);
		 submitParent=submitEl.parent();
		 submitElInnerHTML = submitParent.html();
	}
   
    $.ajax({
			type : 'POST',
			dataType:'json',
			cache : false,
			url : window.BASESITE+o.url,
			data : o.data,
			success : function(jsonObj) {
				if (o.callBack != null && typeof o.callBack == 'function') {
					o.callBack(jsonObj);
				}else{
					Miracle.alert("操作成功");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if(null!=submitParent){
					submitParent.html(submitElInnerHTML);
				}
			},
			beforeSend : function(XMLHttpRequest) {
				if(null!=submitParent){
					submitParent.html("");
				}
			},
			complete : function(XMLHttpRequest, textStatus) {
				if(null!=submitParent){
					submitParent.html(submitElInnerHTML);
				}
			}
    });
    return false;
    
};