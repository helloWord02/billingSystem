<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

   <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
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
            <h1>管理员管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">
               <!-- 查询 -->
                <div  style="text-align:center;">
                    <h3>管理员详细信息</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div style="margin-left: 300px" >

                    <form role="form">
                       <div  >
                            <table align="left">
                                <tr>
                                    <td >
                                        <span>管理员名称：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.realName }</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">管理账号：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.billAccount }</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>密码：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.password }</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">电话：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.phoneNumber }</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>性别：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.gender }</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">身份证：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.idCard }</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>地址：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.address }</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">邮编：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.cord }</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>邮箱：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.mail }</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">QQ：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.qq }</span>
                                    </td>
                                </tr>


                                <tr>
                                    <td>
                                        <span>角色：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${bean.roles.roleName }</span>
                                    </td>

                                </tr>

                            </table>
                       </div>


                    </form>

                 </div>

            </div>
            <button style="width: 100px;height: 40px;margin-left: 450px" type="button" class="btn btn-info" id="cancel">返回</button>

        </div>

    </div>
    <script>
    $("#cancel").click(function(){
    	window.location.href="view/operation/admin/page_admin.jsp";	
	});
    
    </script>
</body>
</html>