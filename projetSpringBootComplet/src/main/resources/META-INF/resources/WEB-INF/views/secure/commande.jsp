<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.servletContext.contextPath }" />
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
		<h1>recapitulatif de votre commande</h1>
		<div>
			<h2>identité:</h2>
			<ul>
				<li>prenom:${personne.prenom}</li>
				<li>nom:${personne.nom}</li>
				<li>email:${personne.email}</li>
				<li>adresse:${personne.adresse }
			</ul>
		</div>
		<div>
			<h2>vos articles</h2>
			<ul>
				<c:forEach items="${panier.keySet()}" var="produit">
					<li>produit:${produit.nom} quantité:${panier.get(produit)}</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<a href="${ctx}/secure/commande/save" class="btn btn-outline-info">valider
				votre commande</a><a href="${ctx}/public/produit" class="btn btn-link">continuer
				vos achats</a>
		</div>
	</div>
</body>
</html>