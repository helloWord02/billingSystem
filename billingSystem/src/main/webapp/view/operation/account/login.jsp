<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() +"://" + request.getServerName() + ":" + 
	request.getServerPort() + path + "/";
%>  

<head>
	<base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登录</title>
 
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/dist/css/sb-admin-2.css" rel="stylesheet">
 
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script src="<%=basePath%>static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="<%=basePath%>static/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="<%=basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="<%=basePath%>static/dist/js/sb-admin-2.js"></script>
     <script type="text/javascript" src="<%=basePath %>static/js/md5.js"></script>
     <script type="text/javascript" src="<%=basePath %>static/js/jquery.cookie.js"></script>

</head>

<body>

<div class="container"  style=" height:600px;background:url(../<%=basePath%>static/img/timg.jpg)">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default"  >
                <div class="panel-heading">
                    <h3 class="panel-title">欢迎登录电信计费系统</h3>
                </div>
                <div class="panel-body" >
                    <form  name="user">
                        <fieldset>
                            <div class="form-group" >
                                <input class="form-control" placeholder="账务账号" name="billAccount" type="text" id="wsc-username">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" id="wsc-password">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember"  type="checkbox"  id="rmbUser">记住用户名
                                </label>
                            </div>

                            <button type="button" onclick="submitform()" class=" btn btn-primary btn-lg btn-block" id="loginbut">登录</button>
                        	<button type="reset" class=" btn btn-primary btn-lg btn-block">重置</button>
                        	
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
var obut=document.getElementById("loginbut");
	function login(){
		
		$.ajax({
			type:"post",
			url:"user/login",
			data: {billAccount:$("#wsc-username").val()+"",password:hex_md5($("#wsc-password").val())+""},
			async:true,
			success:function(data){
				if(data=="0"){
					window.location.href="view/operation/account/main.jsp";
				}else{
					alert("网络异常！");
					window.location.reload(true);
					obut.disabled=false;
				}
			}
		});
		
	}
	
    function submitform(){
    	
    	if($("#wsc-username").val()!=null&&$("#wsc-username").val()!=""&&$("#wsc-password").val()!=null&&$("#wsc-password").val()!=""){
    		obut.disabled=true;
    		saveUserInfo();
    		login();
    	}else{
    		alert("用户名/密码不能为空！");
    	}
        
        
    }
    $(document).ready(function() {
        if ($.cookie("rmbUser") == "true") {
            $("#rmbUser").attr("checked", true);
            $("#wsc-username").val($.cookie("userName"));
            $("#wsc-password").val($.cookie("passWord"));
        }
    });
    var obox=document.getElementById("rmbUser");
    
    function saveUserInfo() {
        if (obox.checked == true) {
            var userName = $("#wsc-username").val();
            var passWord = $("#wsc-password").val();
            $.cookie("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
            $.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
            $.cookie("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
        }else {
            $.cookie("rmbUser", "false", { expires: -1 });        // 删除 cookie
            $.cookie("userName", '', { expires: -1 });
            $.cookie("passWord", '', { expires: -1 });
        }
    }
</script>


</body>

</html>
   