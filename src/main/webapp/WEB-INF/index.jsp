<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1>Product List</h1>
<table class="table">
<thead>
	<tr>
		<th scope="col">ID</th>
		<th scope="col">Name</th>
		<th scope="col">Description</th>
		<th scope="col">Price</th>
		<th scope="col">Category</th>
		<th scope="col">Actions</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="product" items="${allProducts}">
	<tr>
		<td scope="row"><c:out value="${product.id}"></c:out></td>
		<td><c:out value="${product.name}"></c:out></td>
		<td><c:out value="${product.description}"></c:out></td>
		<td><c:out value="${product.price}"></c:out></td>
		<c:forEach items="${product.categories}" var="cat">
		<td><c:out value="${cat.name}"></c:out></td>
		</c:forEach>
		<td>
		<a href="/{product.id}">Show</a>
		<a href=""></a>
		</td>
	</c:forEach>
</tbody>
</table>
<h1>Categories</h1>
<table class="table">
<thead>
<tr>
	<th>Name</th>
</tr>
</thead>
	<c:forEach var="category" items="${allCategories}">
	<tr>
		<td scope="col"><c:out value="${category.name}"></c:out></td>
	</tr>
	</c:forEach>
</table>
<a href="/newProduct">Add a new product</a>
<a href="/newCategory">Add a new category</a>
</body>
</html>