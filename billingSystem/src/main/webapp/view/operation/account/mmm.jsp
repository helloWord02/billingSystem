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

    <title> 账务账号管理</title>

    <link href=" <%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css " rel="stylesheet">
    <script src=" <%=basePath%>static/js/jQuery-2.2.2-min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


    <style>

        body{

            width: 1100px;
        }

        
        .div_content{

            width: 100%;
            height: 600px;
            background-color:  rgba(51, 255, 90, 0.5)

        }
        h1{
            width: 100%;
            line-height: 100px;
            text-align: center;
        }


        img{
            margin:0 auto;

        }

    </style>

</head>
<body>
<div class="divall">
    
    <div class="div_content" >


        <div style="height: 480px" id="carousel-example-generic" class="carousel slide" data-ride="carousel">

            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>


            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<%=basePath%>static/imge/timg.jpg" style="width: 1000px;height: 600px"  alt="...">
                    <div class="carousel-caption">
                       用户主页
                    </div>
                </div>
                <div class="item">
                    <img src=" <%=basePath%>static/imge/log.jpg"  style="width: 800px;height: 600px"  alt="...">
                    <div class="carousel-caption">
                        ...
                    </div>
                </div>
                <div class="item">
                    <img src="<%=basePath%>static/imge/11.jpg" style="width: 800px;height: 600px"   alt="...">
                    <div class="carousel-caption">
                        ...
                    </div>
                </div>

            </div>


            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>



    </div>

</div>



</body>
</html>