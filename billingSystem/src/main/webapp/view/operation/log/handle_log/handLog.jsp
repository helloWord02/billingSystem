<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作日志</title>

  <meta charset="UTF-8">
    <title>操作日志</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>professor-1</title>

    <!-- Bootstrap Core CSS -->
    <link href="../<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../<%=basePath%>static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../<%=basePath%>static/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../<%=basePath%>static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../<%=basePath%>static/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
        <h1>操作日志</h1>
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
                                    <th style="width: 10%;">ip</th>
                                    <th style="width: 10%;">登陆时间</th>
                                    
                                    <th style="width: 15%;">用户名</th>

                                </thead>
                                <tbody>
                                <tr class="gradeA odd" role="row">

                                    <td>111</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>221.237.44.152</td>
     
                                <tr class="gradeA odd" role="row">

                                    <td>122</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>221.237.44.152</td>


                                <tr class="gradeA odd" role="row">

                                    <td>1515</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>221.237.44.152</td>

                                <tr class="gradeA odd" role="row">

                                    <td>1515</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>221.237.44.152</td>

                                <tr class="gradeA odd" role="row">

                                    <td>111</td>
                                    <td>服务器5租用</td>
                                    <td>221.237.44.152</td>
                                    <td>221.237.44.152</td>

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
                  
                </div>

            </div>
          

        </div>

    </div>

</div>


</body>
</html>