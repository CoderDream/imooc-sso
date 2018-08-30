<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<% 
String path = request.getContextPath(); 
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!-- base需要放到head中 --> 
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>

	<center>
		<h1>请登录</h1>
		<form action="<%=basePath%>sso/doLogin.action" method="POST">
			<span>用户名：</span> <input type="text" name="username" /> 
			<span>密码：</span> <input type="password" name="password"> 
			<input type="hidden" name="gotoUrl" value="${gotoUrl}" /> 
			<input type="submit" value="登录" />
		</form>
	</center>
</body>
</html>