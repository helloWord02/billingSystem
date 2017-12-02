<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();//获取项目名称
	String basePath = request.getScheme() +"://" + request.getServerName() + ":" + 
	request.getServerPort() + path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath%>SendMessage" method="post">
	<label>用户名：</label>
	<input type="text" name="userName">
	<br/>
	<label>账号：</label>
	<input type="text" name="userBill">
	<br/>
	<label>密码：</label>
	<input type="text" name="password">
	<br/>
	<label>邮箱：</label>
	<input type="text" name="mail">
	<br/>
	<input type="submit">
</form>
</body>
</html>