<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>Mon super site marchand</h1>
		<nav>
			<jsp:include page="../login/logout.jsp"></jsp:include>
			<a href="${ctx}/public/produit" class="btn btn-link">nos produits</a>
			<sec:authorize access="isAnonymous()">
				<a href="${ctx}/login" class="btn btn-link">connexion</a>
				<a href="${ctx}/public/inscription" class="btn btn-link">inscription</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${ctx}/admin/personne" class="btn btn-link">gestion des
					utlisateurs</a>
			</sec:authorize>
		</nav>
		<c:choose>
			<c:when test="${param.commande !=null }">
				<div class="alert alert-success">votre commande
					numero:${param.commande} a bien été enregistré</div>
			</c:when>
		</c:choose>
		<div>
			<c:if test="${personne != null }">
				<h2>vos dernieres commandes</h2>
			</c:if>
			<table class="table">
				<c:forEach items="${personne.commandes}" var="commande">
					<tr>
						<td>${commande.id}</td>
						<td><fmt:parseDate value="${commande.dateCommande}"
								pattern="yyyy-MM-dd" var="dateC" type="date"></fmt:parseDate> <fmt:formatDate
								value="${dateC}" pattern="dd/MM/yyyy" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>