<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Details</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<h1>This Dojo's Ninjas</h1>
	State Name: ${dojo.name}
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${ dojo.ninjas }' var='ninja'>
				<tr>
					<th scope="row">${ninja.id}</th>
					<td>${ninja.firstname}</td>
					<td>${ninja.lastname}</td>
					<td>${ninja.age}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
</body>
</html>