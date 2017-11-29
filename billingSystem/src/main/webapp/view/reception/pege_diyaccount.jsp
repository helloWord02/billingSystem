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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户自助服务系统</title>

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
    <div  style="text-align:center;">
        <h3>查看账务信息</h3><br><br>
    </div>
    <div  >
        <span>月份：</span>
        <input  style=" width: 140px;height: 30px; border: 1px rgba(105, 99, 70, 0.5) solid" placeholder="月份" name="month" type="text" >
        <button id="find" type="button" class="btn btn-info">查询</button>
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
                                    <th style="width: 10%;">月份</th>
                                    <th style="width: 20%;">费用</th>
                                    <th style="width: 20%;">支付方式</th>
                                    <th style="width: 20%;">支付状态</th>
                                </thead>
                                <tbody>
                                <tr class="gradeA odd" role="row">
                                    <td class="sorting_1">1</td>
                                    <td>服务器1租赁</td>
                                    <td>221.237.44.152</td>
                                    <td>111</td>

                                <tr class="gradeA odd" role="row">
                                    <td class="sorting_1">2</td>
                                    <td>服务器2租赁</td>
                                    <td>221.237.44.152</td>
                                    <td>122</td>


                                <tr class="gradeA odd" role="row">
                                    <td class="sorting_1">3</td>
                                    <td>服务器3租赁</td>
                                    <td>221.237.44.152</td>
                                    <td>1515</td>

                                <tr class="gradeA odd" role="row">
                                    <td class="sorting_1">4</td>
                                    <td>服务器4租用</td>
                                    <td>221.237.44.152</td>
                                    <td>1515</td>


                                <tr class="gradeA odd" role="row">
                                    <td class="sorting_1">5</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>111</td>

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
	                                                <span class="input-group-addon" id="span1">
	                                                </span>
                                            <input style="width: 70px" type="text" class="form-control" placeholder="跳转页" id="page">
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /翻页按钮-->
                </div>

            </div>
            <!-- 表格 -->

        </div>

    </div>

</div>


</body>
</html>