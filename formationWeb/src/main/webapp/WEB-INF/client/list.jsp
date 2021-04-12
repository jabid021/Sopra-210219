<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		el=>parametre requete=>requete=>session=>servletContext
	 -->
	<table>
		<c:forEach items="${clients}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.prenom}</td>
				<td>${c.nom}</td>
				<td><a href="?query=edit&id=${c.id}">editer</a></td>
				<td><a href="?query=delete&id=${c.id}">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="?query=add">creation client</a>
</body>
</html>