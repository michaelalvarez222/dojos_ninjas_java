<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<h1>Welcome ${loggedInUser.userName}</h1>
	<h1>New Dojo's</h1>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${allDojos}' var='dojo'>
				<tr>
					<th scope="row">${dojo.id}</th>
					<td><a href="/dojo/${dojo.id}">${dojo.name}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Create New Dojo</h1>
	<form:form action="/dojo/create" method="post" modelAttribute = "dojo">
	<div class="form-group">
		<form:label path="name">Name</form:label>
		<form:errors path="name" class ="text-danger"/>
		<form:input type= "text" path="name" class="form-control"/>
	</div>
	<input type="submit" value="Submit">
</form:form>
<a href="/new/ninja">Create Ninja</a>
</body>
</html>