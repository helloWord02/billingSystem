<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

   
    <title>电信系统</title>
 
    <link href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/dist/css/sb-admin-2.css" rel="stylesheet">
 
    <link href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>static/js/jQuery-2.2.2-min.js" type="text/javascript"></script>
        
        <script src="<%=basePath%>static/bower_components/jquery/dist/jquery.min.js"></script>
 
        <script src="<%=basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
 
        <script src="<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.js"></script>
 
        <script src="<%=basePath%>static/dist/js/sb-admin-2.js"></script>
   
    <style>
        .iframe1{
            width: 1100px;
            height: 600px;
            margin-left: -49px;
            position: absolute;
            left: 300px;
            top: 80px;
        }

    </style>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0 ;background-color:white">
            <div class="navbar-header" style="height: 80px;line-height: 80px; " >
                <img src="static/imge/log.jpg" style="width: 250px;height: 80px">
                <h1 style="margin-left: 350px;display: inline">电信计费服务系统</h1>

            </div>
            <ul class="nav navbar-top-links navbar-right" style="margin-top: 20px" >
                <li class="dropdown" >
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        <h5 style="display: inline;height:100%;margin-left: 20px">欢迎<shiro:principal/>登录！</h5>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="page_person_info.html"  target="myiframe"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="page_person_upd.html"  target="myiframe"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="user/loginout"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>


            <div class="navbar-default sidebar" role="navigation" style="margin-top: 80px">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                        <shiro:hasPermission name="/userselfroot"><li>
                            <a ><i class=" fa fa-user fa-fw"></i> 用户自服务系统<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="view/reception/page_diyaccount.jsp" target="myiframe">查询账单</a>
                                </li>
                                <li>
                                    <a href="view/reception/page_person_upd.jsp" target="myiframe">修改个人信息</a>
                                </li>
                            </ul>
                        </li></shiro:hasPermission>
                        <shiro:hasPermission name="/userroot"><li>
                            <a ><i class="fa fa-bar-chart-o fa-fw"></i> 用户管理系统<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="  view/operation/log/handLog.jsp" target="myiframe">账务账号管理</a>
                                </li>
                                <li>
                                    <a href=" view/operation/log/loginLog.jsp" target="myiframe">业务账号管理</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li></shiro:hasPermission>

                        <shiro:hasPermission name="/adminroot"><li>

                            <a href="view/operation/admin/page_admin.jsp" target="myiframe"><i class="fa fa-desktop  fa-fw"></i> 管理员管理系统</a>
                        </li></shiro:hasPermission>

                       <shiro:hasPermission name="/zifeiroot"> <li>
                            <a href="view/operation/postage/page_postage.jsp" target="myiframe"><i class="fa fa-edit fa-fw"></i>资费管理系统</a>  
                        </li></shiro:hasPermission>
                       <shiro:hasPermission name="/zhangdanroot"> <li>
                            <a href="view/operation/bill/page_bill.jsp" target="myiframe"><i class="fa fa-edit fa-fw"></i>账单查询系统</span></a>

                            <!-- /.nav-second-level -->
                        </li></shiro:hasPermission>
                        <shiro:hasPermission name="/zhangwuroot"><li>
                            <a href=" view/operation/account/page_account.jsp " target="myiframe"><i class="fa fa-edit fa-fw"></i>账务查询系统</span></a>

                            <!-- /.nav-second-level -->
                        </li></shiro:hasPermission>
                       <shiro:hasPermission name="/root"> <li >
                            <a ><i class="fa fa-files-o fa-fw"></i> 权限管理系统<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="active" href="view/operation/admin/page_role.jsp" target="myiframe">角色管理</a>
                                </li>
                                <li>
                                    <a href="view/operation/admin/page_permission.jsp" target="myiframe">权限管理</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li></shiro:hasPermission>
                        <shiro:hasPermission name="/logroot"><li >
                            <a><i class="fa fa-hospital-o  fa-fw"></i> 前台日志系统<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="active" href=" view/operation/log/loginLog.jsp" target="myiframe">登录服务日志</a>
                                </li>
                                <li>
                                    <a href="  view/operation/log/handLog.jsp" target="myiframe">操作服务日志</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li></shiro:hasPermission>
                        <shiro:hasPermission name="/baobiaoroot"><li>
                            <a><i class="fa fa-calendar  fa-fw"></i> 报表查询系统<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="active" href="xx.html" target="myiframe">账务账单报表</a>
                                </li>
                                <li>
                                    <a href="xxx.html" target="myiframe">业务账单报表</a>
                                </li>
                            </ul>
                            <!-- /报表系统 -->
                        </li></shiro:hasPermission>
                    </ul>
                </div>

            </div>


        </nav>


        <div id="page-wrapper">
            <iframe class="iframe1" src="view/operation/account/mmm.jsp  " frameborder="0" name="myiframe" style="margin-top: -20px">
            </iframe>
        </div>

    </div>

    <div id="div_foot" style="width: 1366px;height: 100px;background-color: rgba(212, 212, 212, 0.5);text-align: center;">
            <br>
            <p>**********2017年11月26日************<p>
            <p>**********中国电信互联网中心成都一分部************</p>
            
    </div>

</body>

</html>
   