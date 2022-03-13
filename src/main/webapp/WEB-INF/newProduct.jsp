<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Product</title>
</head>
<body>
<h1>Add a new product</h1>


<form:form class="form" action="/newProd" method="post" modelAttribute="product">
<div class="form-control">
	<form:errors path="name" class="errors"></form:errors>
	<form:label path="name">Name: </form:label>
	<form:input type="text" path="name"/>
</div>
<div class="form-control">	
	<form:errors path="description" class="errors"></form:errors>
	<form:label path="description">Description:</form:label>
	<form:input type="text" path="description"/>
</div>
<div class="form-control">
	<form:errors path="price" class="errors"></form:errors>
	<form:label path="price">Price</form:label>
	<form:input type="text" path="price"/>
</div>

	<form:label path="categories">Category: </form:label>
<div class="form-control">
	<form:select path="categories">
	<c:forEach var="category" items="${allCategories}">
		<option value="${category.id}">${category.name}</option>
	</c:forEach>
	</form:select>
</div>
	
	<input type="submit" class="btn btn-primary" value="Create">
</form:form>

<a href="/">Go back</a>
</body>
</html>