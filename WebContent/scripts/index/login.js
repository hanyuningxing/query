$(document).ready(function (){
	$('#username').focus();
	formValidate();
	$('#loginImg').bind('click',submit);
});

function submit(){
	if($('#loginForm').valid()){
		var url = "/user/login";
		var formObj = $("#loginForm");
		formObj.attr("action",url);
		formObj.submit();
	}
}
function formValidate(){
	$('#loginForm').validate({
		rules:{
			username:{
				required : true
			},
			password:{
				required: true
			},
			jcaptchaPassword:{
				required: true
			}
		},
		messages:{
			username: {
				required : "请输入用户名"
			},
			password: {
				required: "请输入密码"
			},
			jcaptchaPassword: {
				required: "请输入验证码"
			}
		}
	});
}