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
                    <form role="form" action="user/login " method="post" >
                        <fieldset>
                            <div class="form-group" >
                                <input class="form-control" placeholder="账务账号" name="billAccount" type="text" >
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">记住密码
                                </label>
                            </div>

                            <button type="submit" class=" btn btn-primary btn-lg btn-block">登录</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



</body>

</html>
   