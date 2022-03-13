<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Category</title>
</head>
<body>
<h3>Add a new category</h3>


<form:form class="form" action="/newCat" method="post" modelAttribute="category">
	<form:errors path="name" class="errors"></form:errors>
	<form:label path="name">Name: </form:label>
	<form:input type="text" path="name"/>
	<input type="submit" class="btn btn-primary" value="Create">
</form:form>

<a href="/">Go back</a>

</body>
</html>