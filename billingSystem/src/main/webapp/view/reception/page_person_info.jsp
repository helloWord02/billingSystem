<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>用户信息</title>

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
	
	<script type="text/javascript" src="<%=basePath%>static/js/jQuery-2.2.2-min.js" ></script>
 
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
            align:left;
            height: 50px;
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
            <div  style="text-align:center;">
                <h3>查看个人信息</h3><br><br>
            </div>
            <!-- 查询  -->

            <div style="margin-left: 300px" >

                <form role="form">
                    <div  >
                        <table align="left">
                            <tr>
                                <td >
                                    <span>账务账号：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">${account.bill_account}</span>
                                </td>
                                <td>
                                    <span style="margin-left: 50px">真实姓名：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">${account.real_name}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>联系电话：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">13258187859</span>
                                </td>
                                <td>
                                    <span style="margin-left: 50px">身份证：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">510703199508240231</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span>邮  编：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">621000</span>
                                </td>
                                <td>
                                    <span style="margin-left: 50px">Q Q：</span>
                                </td>
                                <td>
                                    <span style="margin-left: 20px; ">623318826</span>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <button id="back" style="width: 100px;height: 40px;margin-left: 450px" type="button" class="btn btn-info">返回</button>
    </div>

</div>
<script>

    $("#back").on("click",function(){
        window.open("page_diyaccount.html","_self")
    });
</script>

</body>
</html>