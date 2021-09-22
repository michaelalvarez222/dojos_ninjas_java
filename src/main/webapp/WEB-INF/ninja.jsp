<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>

	<h1>Holla</h1>
	<form:form action="/create/ninja" method="post" modelAttribute = "ninja">
			<div class="form-group">
				<form:label path="firstname">First Name</form:label>
				<form:errors path="firstname" class ="text-danger"/>
				<form:input type= "text" path="firstname" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:errors path="lastname" class ="text-danger"/>
				<form:input type="text" path="lastname" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="age">Age</form:label>
				<form:errors path="age" class ="text-danger"/>
				<form:input type="number" path="age" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="dojo">Dojo</form:label>
				<form:errors path="dojo" class ="text-danger"/>
				<form:select path="dojo" class="form-select">
					<c:forEach items='${ allDojos }' var='dojo'>
						<option value="${dojo.id}">${dojo.name}</option>
					</c:forEach>
					
				</form:select>
				
			</div>
			<input type="submit" value="Submit">
		</form:form>
</body>
</html>