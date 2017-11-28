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

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改资费</title>

    <!-- Bootstrap Core CSS -->
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
            <h1>资费管理系统</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>修改资费</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div  >

                    <form role="form" style="text-align: center">
                        <span>资费名称：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="资费名称" name="businessName" type="text" ><br><br>
                        <span style="margin-left: -100px">资费类型：</span>
                        <select name="select" id="select_k1"  style="margin-left: 20px;width: 100px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid">
                            <option value="包月">包月</option>
                            <option value="计时">计时</option>
                            <option value="套餐">套餐</option>
                        </select><br><br>
                       <span>基本时长：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="基本时长" name="basicTime" type="text" ><br><br>
                        <span>基本费用：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="基本费用" name="basicCost" type="text" ><br><br>
                        <span>单位费用：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="单位费用" name="cost" type="text" ><br><br>
                        <span>资费说明：</span>
                        <input  style="margin-left: 20px;width: 200px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="资费说明" name="info" type="text" ><br><br>
                        <button style="width: 100px;height: 40px" type="submit" class="btn btn-info">修改</button>
                        <button id="cancel" style="width: 100px;height: 40px;margin-left: 80px" type="button" class="btn btn-info">取消</button>


                    </form>

                 </div>
            </div>

        </div>

    </div>
    <script>

        $("#cancel").on("click",function(){
            window.open("view/operation/postage/page_postage.jsp","_self")
        });
    </script>

</body>
</html>