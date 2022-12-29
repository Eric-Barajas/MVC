<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
<%-- 	<form action="/books" method="POST">
		<div>
			<label name="title">Title:</label>
			<input type="text" name="title" id="" />
		</div>
		<div>
			<label name="description">Description:</label>
			<input name="description" id="" />
		</div>
		<div>
			<label name="language">Language:</label>
			<input name="language" id="" />
		</div>
		<div>
			<label name="numberOfPages">Number of pages:</label>
			<input type="number" name="numberOfPages" id="" />
		</div>
		<input type="submit" value="submit"/>
	</form> --%>
	
	<!-- USING DATA BINDING  -->
	<!-- the form: exposes the form and data to data binding -->
	<form:form modelAttribute="aBook" action="/books" method="POST">
		<!-- modelAttrivute matches @modelAttribute in @Getmapping BookController -->
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title" class="text-danger" />
			<form:input path="title" id="" />
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:textarea path="description" id="" />
		</div>
		<div>
			<form:label path="language">Language:</form:label>
			<form:errors path="language" class="text-danger" />
			<form:input path="language" id="" />
		</div>
		<div>
			<form:label path="numberOfPages">Number of pages:</form:label>
			<form:errors path="numberOfPages" class="text-danger" />
			<form:input type="number" path="numberOfPages" id="" />
		</div>
		<input type="submit" value="submit"/>
		<!-- submit button doesn't need form tag -->
		<!-- path names have to match member variables -->
	</form:form>
</body>
</html>