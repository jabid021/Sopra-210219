<%@page import="java.util.List"%>
<%@page import="formation.entity.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
		for (Personne p : (List<Personne>) request.getAttribute("clients")) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getPrenom()%></td>
			<td><%=p.getNom()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>