<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>edition personne</h1>
	<form action="?query=save" method="post">
<%-- 		<input type="hidden" name="version" value="${personne.version}"> --%>
		<div>
			id:<input name="id" readonly="readonly" value="${personne.id}">
		</div>
		<div>
			prenom:<input name="prenom" value="${personne.prenom}">
		</div>
		<div>
			nom:<input name="nom" value="${personne.nom}">
		</div>
		<div>
			<button type="submit">enregistrer</button>
			<a href="client">annuler</a>
		</div>
	</form>
</body>
</html>