<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (request.getParameter("erreur") != null) {
	%>
	<div>prenom obligatoire</div>
	<%
	}
	%>
	<form action="bonjour" method="get">
		prenom:<input name="prenom">
		<button type="submit">envoyer</button>
	</form>
</body>
</html>