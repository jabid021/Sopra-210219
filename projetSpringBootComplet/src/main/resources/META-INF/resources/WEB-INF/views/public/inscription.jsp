<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript">
	function onChange() {
		const password = document.querySelector('input[name=password]');
		const confirm = document.querySelector('input[name=confirm]');
		console.log('check')
		if (confirm.value === password.value) {
			confirm.setCustomValidity('');
		} else {
			confirm.setCustomValidity('Passwords do not match');
		}
	}
</script>
<title>eshop</title>
</head>
<body>
	<div class="container">
		<form:form action="${ctx}/public/inscription" method="post"
			modelAttribute="personne">
			<form:hidden path="version" />
			<input type="hidden" name="source" value="${source}" />
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true"
					placeholder="generer automatiquement" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" cssClass="form-control" />
				<form:errors path="prenom" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
				<form:errors path="nom" element="div" cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="email">email:</form:label>
				<form:input type="email" path="email" cssClass="form-control" />
				<form:errors path="email" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="password">mot de passe:</form:label>
				<form:input type="password" path="password" cssClass="form-control"
					onchange="onChange()" />
				<form:errors path="password" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<label for="confirm">confirmer votre mot de passe:</label> <input
					type="password" class="form-control" name="confirm"
					value="${confirm}" onchange="onChange()" />
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero rue:</form:label>
				<form:input type="number" path="adresse.numero"
					cssClass="form-control" />
				<form:errors path="adresse.numero" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.rue"> rue:</form:label>
				<form:input path="adresse.rue" cssClass="form-control" />
				<form:errors path="adresse.rue" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.codePostal"> code postal:</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control" />
				<form:errors path="adresse.codePostal" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.ville"> ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control" />
				<form:errors path="adresse.ville" element="div"
					cssClass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<c:choose>
					<c:when test="${param.source != null }">
						<a href="${ctx}/public/produit" class="btn btn-outline-warning">annuler</a>
					</c:when>
					<c:otherwise>
						<a href="${ctx}/public" class="btn btn-outline-warning">annuler</a>
					</c:otherwise>
				</c:choose>


			</div>
		</form:form>
	</div>
</body>
</html>