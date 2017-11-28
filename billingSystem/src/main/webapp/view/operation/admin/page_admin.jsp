<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <h1>管理员管理</h1>
        </div>

        <div class="div_content">

            <div class="panel-body">


                <!-- 表格  -->
                <div class="dataTable_wrapper">

                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered table-hover dataTable no-footer" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info">

                                <thead>
                                    <tr role="row">
                                        <th style="width: 20%;">管理员名称</th>
                                        <th style="width: 20%;">账号</th>
                                        <th style="width: 20%;">性别</th>
                                        <th style="width: 20%;">联系电话</th>
                                    </thead>
                                    <tbody>
                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">123</td>
                                        <td>123</td>
                                        <td>1232</td>
                                        <td>123</td>

                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">2</td>
                                        <td>123</td>
                                        <td>123</td>
                                        <td>123</td>


                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">2</td>
                                        <td>123</td>
                                        <td>123</td>
                                        <td>123</td>

                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">2</td>
                                        <td>123</td>
                                        <td>123</td>
                                        <td>123</td>


                                    <tr class="gradeA odd" role="row">
                                        <td class="sorting_1">2</td>
                                        <td>123</td>
                                        <td>123</td>
                                        <td>123</td>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!--翻页按钮-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button  " aria-controls="dataTables-example" tabindex="0" id="a1"><a>首页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="1" id="a2"><a>上一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="2" id="a3"><a>下一页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="3" id="a4"><a>尾页</a></li>
                                        <li class="paginate_button " aria-controls="dataTables-example" tabindex="4" id="a5"><a >跳转</a></li>
                                        <li aria-controls="dataTables-example" tabindex="4">
                                            <div class="form-group input-group">
                                                <input style="width: 70px" type="text" class="form-control" placeholder="跳转页" id="page">
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                        <!-- /翻页按钮-->
                        <div style="text-align: left" >
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px" >增加管理员</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px">删除管理员</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px">修改管理员</button>
                            <button type="button" class="btn btn-info" style="width: 100px;height: 40px">管理员信息</button>

                        </div>

                    </div>

                </div>
                <!-- 表格 -->

            </div>

        </div>

    </div>
</body>
</html>