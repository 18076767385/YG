<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%session.setAttribute("key", request.getParameter("id"));%>
<form action="Award" method="Post">
回复内容：<textarea rows="15" cols="50" name="yi">
</textarea>
<input type="submit" value="提交">
</form>
</body>
</html>