<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
<title>Todo</title>
</head>
<body>

	<nav class="navbar navbar-default">

		<a href="/" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/todo.do">Todos</a></li>
			<li><a href="http://www.in28minutes.com">In28Minutes</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">Logout</a></li>
		</ul>
	</nav>

	<div class="container">
		<h1>Welcome ${name}</h1>
		Your Todo's are:
		<ol>
			<c:forEach items="${todos}" var="todo">
				<li>${todo.name}&nbsp;&nbsp;<a
					href="\delete-todo.do?todo=${todo.name}">Delete</a></li>
			</c:forEach>
		</ol>

		<p>
			<font color="red">${errorMessage}</font>
		</p>

		<form action="/add-todo.do" method="post">
			New Todo: <input type="text" name="todo" /> <input type="submit"
				value="Submit Query" />
		</form>
	</div>

	<footer class="footer">
		<div>footer content</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>