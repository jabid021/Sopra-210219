<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="color: red">
		<%
		if (request.getParameter("erreur") != null) {
			if (request.getParameter("erreur").equals("empty")) {
		%>
		<span>login et mot de passe obligatoire</span>
		<%
		} else if (request.getParameter("erreur").equals("login")) {
		%>
		<span>il faut d'abord vous connecter</span>
		<%
		} else {
		%>
		<span>informations fausses</span>
		<%
		}
		}
		%>
	</div>
	<div>
		<form action="login" method="post">
			login:<input name="login">mot de passe:<input name="password">
			<button type="submit">envoyer</button>
		</form>
	</div>
</body>
</html>