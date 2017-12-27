<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎回来：
<c:forEach items="${requestScope.listt }" var="keyword" varStatus="id">

${id.count }&nbsp;留言：${keyword.getLiuyan() }&nbsp;<a href="huifu.jsp?id=${keyword.getId() }">回复</a>
<br>
</c:forEach>
</body>
</html>