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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="test/t" method="get">
测试mvc<input type="text" name="userName">
<input type="submit" value="提交">
</form>
</body>
</html>