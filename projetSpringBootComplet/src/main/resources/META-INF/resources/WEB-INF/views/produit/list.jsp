<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<title>eshop</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../login/logout.jsp"></jsp:include>
		<h1>liste des produits</h1>
		<c:choose>
			<c:when test="${param.success != null}">
				<div class="alert alert-info">produit ajouté au panier</div>
			</c:when>
			<c:when test="${param.error != null}">
				<div class="alert alert-danger">erreur! recommencer</div>
			</c:when>
			<c:when test="${param.remove != null}">
				<div class="alert alert-info">produit supprimé du panier</div>
			</c:when>
			<c:when test="${param.edit != null}">
				<div class="alert alert-info">produit modifié</div>
			</c:when>
			<c:when test="${param.delete != null}">
				<div class="alert alert-info">produit supprimé</div>
			</c:when>
		</c:choose>
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
						</c:choose></td>
					<sec:authorize access="hasRole('ROLE_USER')||isAnonymous()">
						<td><a href="${ctx}/public/panier/add?id=${p.id}"
							class="btn btn-outline-primary">ajouter au panier</a></td>
						<c:choose>
							<c:when test="${panier.get(p) != null }">
								<td>${panier.get(p)}</td>
								<td><a href="${ctx}/public/panier/remove?id=${p.id}"
									class="btn btn-outline-danger">retirer</a></td>
							</c:when>
							<c:otherwise>
								<td></td>
								<td></td>
							</c:otherwise>
						</c:choose>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a href="${ctx}/admin/produit/edit?id=${p.id}"
							class="btn btn-outline-primary">editer</a></td>
						<td><a href="${ctx}/admin/produit/delete?id=${p.id}"
							class="btn btn-outline-danger">supprimer</a></td>
						<td></td>
					</sec:authorize>
				</tr>

			</c:forEach>
		</table>
		<sec:authorize access="isAnonymous()">
			<a href="${ctx}/login?source=panier" class="btn btn-link">enregistrer
				la commande</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<a href="${ctx}/secure/commande" class="btn btn-link">enregistrer
				la commande</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="${ctx}/admin/produit/add" class="btn btn-link">creation
				de produit</a>
		</sec:authorize>

	</div>
</body>
</html>