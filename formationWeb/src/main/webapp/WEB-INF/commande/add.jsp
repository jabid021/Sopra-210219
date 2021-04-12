<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
	integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
	integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="?query=save" method="post">
			<div class="form-group">
				<label for="id">id:</label> <input id="id" name="id"
					readonly="readonly" class="form-control" value="${commande.id}">
			</div>
			<div class="form-group">
				<label for="dateCommande">date commande:</label> <input type="date"
					id="dateCommande" name="dateCommande" class="form-control"
					value="${commande.dateCommande}">
			</div>
			<div>
				<label>client:</label> <select class="form-control" name="client.id">
					<c:forEach items="${clients}" var="client">
						<option value="${client.id}">${client.infos}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-control">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>