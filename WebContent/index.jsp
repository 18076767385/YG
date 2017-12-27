<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String Status="登录";
if(request.getAttribute("Status")!=null)
	Status="已登录";
%>
<a href="Login.jsp"><%=Status %></a><br>
<a href="zuce.jsp">注册</a><br>
<a href="LiuyanServlet">留言</a><br>
<a href="gg">注销</a>
</body>
</html>