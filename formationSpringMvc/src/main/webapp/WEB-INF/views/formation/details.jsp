<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>details de la formation ${formation.id}</h1>
		<h2>informations</h2>
		<div>
			<ul>
				<li>formateur
					referent:${formation.referent.prenom}&nbsp;${formation.referent.nom}
				</li>
				<li>date de la formation:<fmt:parseDate
						value="${formation.dateFormation}" pattern="yyyy-MM-dd"
						var="dateFormationAvecFormatage"></fmt:parseDate> <fmt:formatDate
						value="${dateFormationAvecFormatage}" pattern="dd/MM/yyyy" /></li>
				<li>liste des modules
					<table class="table">
						<tr>
							<th>nom du module</th>
							<th>formateur</th>
							<th>date du module</th>
							<th>duree</th>
						</tr>
						<c:forEach items="${formation.modules}" var="module">
							<tr>
								<td>${module.id.module.nom}</td>
								<td>${module.intervenant.prenom}&nbsp;${module.intervenant.nom}</td>
								<td>${module.dateModule}</td>
								<td>${module.id.module.duree}</td>
							</tr>
						</c:forEach>
					</table>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>