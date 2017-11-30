<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() +"://" + request.getServerName() + ":" + 
	request.getServerPort() + path + "/";
%> 
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="IE=edge">  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户修改</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<%=basePath%>static/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<%=basePath%>static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
    
    <style>

        body{
            /*iframe宽我设置为1000，网页body的宽度也应该设置为1000*/
            width: 1000px;
        }

        .div_header{
            width: 1000px;
            height: 100px;
            background-color: rgba(179, 227, 255, 0.5);
        }

        .div_content{

            width: 100%;
            height: 480px;

        }

        h1{
            width: 100%;
            line-height: 100px;
            text-align: center;
        }
        td
        {
            text-align:center;
        }
        th{
            text-align:center;
        }


    </style>

</head>
<body>
<div class="divall">
    <div class = "div_header">
        <h1>用户自助系统</h1>
    </div>

    <div class="div_content">

        <div class="panel-body">
            <!-- 查询 -->
            <div  style="text-align:center;margin-top: -20px">
                <h3>修改个人信息</h3><br><br>
            </div>
            <!-- 查询  -->
  
            <div style="margin-top: -20px" >

                <form  style="text-align: center" action="receptions/upd" method="post">
                	<input type="hidden" value="${account.id}" name="id">
                    <span>账务账号：</span>
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="账务账号" name="billAccount" type="text" value= ${account.billAccount} ><br><br>
                    <span>真实姓名：</span>
                     <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="真实姓名" name="realName" type="text" value= ${account.realName} ><br><br>       
                    <span>密  码：</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="密码" name="password" type="text" value= ${account.password} ><br><br>
                    <span>联系电话：</span>
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="联系电话" name="phoneNumber" type="text"   value= ${account.phoneNumber}><br><br>
                    <span>身份证 ：</span>
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="身份证" name="idCard" type="text"   value= ${account.idCard}><br><br>                   
                    <span>邮  编：</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="邮编" name="cord" type="text" value= ${account.cord}><br><br>
                    <span>Q  Q：</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="QQ" name="qq" type="text" value= ${account.qq} ><br><br>
                    <button id="upd" style="width: 100px;height: 40px" type="submit" class="btn btn-info">修改</button>
                    <button id="cancel" style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info">取消</button>
                </form>

            </div>
        </div>

    </div>

</div>
<script>

    $("#cancel").on("click",function(){
        window.open("page_person_info.html","_self")
    });
    
    
</script>

</body>
</html>