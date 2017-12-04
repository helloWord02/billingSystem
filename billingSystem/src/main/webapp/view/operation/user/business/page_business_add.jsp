<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() +"://" + request.getServerName() + ":" + 
	request.getServerPort() + path + "/";
%>  

<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
<title>业务账号管理</title>

	<link href="static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="static/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
   
   <style>

        body{
            /*iframe宽我设置为1000，网页body的宽度也应该设置为1000*/
            width: 1100px;
        }

        .div_header{
            width: 1100px;
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
        td{
            align:left;
            height: 50px;
        }


    </style>

</head>
<body>
<div class="divall">
        <div class = "div_header">
            <h1>业务账号管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>添加业务账号</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div  >

                  <form style="text-align: center" action="business/add" method="post" onsubmit="return notnull()"/>
                        <span>业务账号&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</span>
                        <input   style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="业务账号" name="businessAccount"  type="text" ><br><br>
						<span>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp   码&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  ：</span>
                        <input   style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="密码" name="password"  type="text" ><br><br>
						<span>账务账号&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="账务账号" name="account.billAccount" type="text" ><br><br>
                        <span>实验室IP&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</span>
                        <input   style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="实验室IP" name="ip" type="text" ><br><br>  
                         <span  style="margin-left: -100px  " >资费名称&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp：</span> 
						<select name="postage.postageName"    style="margin-left: 20px;width: 100px;height: 30px; border: 1px rgba(100, 99, 70, 0.5) solid  "style="margin-left: 20px;width: 100px;height: 30px; border: 1px rgba(100, 99, 70, 0.5) solid  ">
                        
                        
                        <button id="add" style="width: 100px;height: 40px" type="submit" class="btn btn-info">添加</button>
                        <button id="cancel" style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info">取消</button>

                    </form>

                 </div>
            </div>

        </div>

    </div>
	<script>

        $("#cancel").on("click",function(){
            window.open("view/operation/user/business/page_business.jsp","_self")
        });
		
    </script>
	
</body>
</html>