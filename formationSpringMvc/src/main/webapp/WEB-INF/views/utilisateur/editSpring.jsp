<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<c:set var="ctx" value="${pageContext.servletContext.contextPath }" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>formulaire avec spring</h1>
		<form:form action="${ctx}/utilisateur/save" method="post"
			modelAttribute="utilisateur">
			<div class="form-group">
				<form:label path="prenom">prenom</form:label>
				<form:input path="prenom" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">
				<form:label path="nom">nom</form:label>
				<form:input path="nom" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/utilisateur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>

		<%-- 		<form action="${ctx}/utilisateur/save" method="post"> --%>
		<%-- 			<input type="hidden" name="index" value="${index}"> --%>
		<!-- 			<div class="form-group"> -->
		<!-- 				<label>prenom</label> <input name="prenom" class="form-control" -->
		<%-- 					value="${utilisateur.prenom}"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<label>prenom</label> <input name="nom" class="form-control" -->
		<%-- 					value="${utilisateur.nom}"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<button type="submit" class="btn btn-outline-success">enregistrer</button> -->
		<%-- 				<a href="${ctx}/utilisateur" class="btn btn-outline-warning">annuler</a> --%>
		<!-- 			</div> -->
		<%-- 		</form> --%>
	</div>
</body>
</html>