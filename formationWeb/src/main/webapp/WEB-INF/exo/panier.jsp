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
		<h1>liste des produits</h1>
		<table class="table">
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>description</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td><c:choose>
							<c:when test="${p.description.length() < 20 }">${p.description}</c:when>
							<c:otherwise>${p.description.substring(0,17)}...</c:otherwise>
						</c:choose> <%-- 					<c:if test="${p.description.length() < 20 }">${p.description.substring(0,20)}</c:if> --%>

					</td>
					<td><a href="?query=add&id=${p.id}"
						class="btn btn-outline-primary">ajouter au panier</a></td>
					<c:choose>
						<c:when test="${panier.get(p) != null }">
							<td>${panier.get(p)}</td>
							<td><a href="?query=remove&id=${p.id}"
								class="btn btn-outline-danger">retirer</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
						</c:otherwise>
					</c:choose>
				</tr>

			</c:forEach>
		</table>
		<a href="?query=save" class="btn btn-link">enregistrer la commande</a>
	</div>
</body>
</html>