<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
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
                    <h3>业务账号详细信息</h3><br><br>
                </div>
                <!-- 查询  -->

                 <div style="margin-left: 300px" >

                    <form role="form">
                       <div  >
                            <table align="left">
                                <tr>
                                    <td >
                                        <span>业务账号：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.businessAccount}</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">密码：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.password}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>账务账号：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.account.billAccount}</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 50px">资费管理类型：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.postage.postageName}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>实验室IP：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.ip}</span>
                                    </td>
                                     <td>
                                      <span style="margin-left: 50px">状态：</span>
                                    </td>
                                    <td>
                                        <span style="margin-left: 20px; ">${Businesstinfo.state==0?'开通':'关闭'}</span>
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
            window.open("view/operation/user/business/page_business.jsp","_self")
        });
    </script>
</body>
</html>