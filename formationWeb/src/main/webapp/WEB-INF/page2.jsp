<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page2</h1>
	<%
	Cookie tab[] = request.getCookies();
	for (Cookie c : tab) {
	%>
	<%=c.getName()%>
	<%=c.getValue()%>
	<%
	}
	%>
</body>
</html>