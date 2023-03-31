<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<h1>
			<c:if test="${not empty sessionScope.USERNAME}"> 
				Welcome ${ sessionScope.USERNAME }
			</c:if>
			<c:if test="${empty sessionScope.USERNAME}"> 
				Welcome
			</c:if>
		</h1>
		<div class="tabs">
			<form action="book-manager" method="get">
				<input type="submit" value="Home">
			</form>
			<c:if test="${sessionScope.PRIVILEGE == 'USER'}">
				<form action="book-manager-user" method="get">
					<input type="submit" value="Profiles">
				</form>
			</c:if>
			<c:if test="${sessionScope.PRIVILEGE == 'ADMIN'}">
				<form action="book-manager-admin" method="get">
					<input type="submit" value="Manage">
				</form>
			</c:if>
		</div>
		<nav>
			<ul>
				<li>
					<form action="book-manager" method="post">
						<p>
							<c:if test="${not empty sessionScope.LOGIN_INCORRECT}"> 
								${ sessionScope.LOGIN_INCORRECT }
							</c:if>
						</p>
						<input type="text" name="username" placeholder="Username">
						<input type="password" name="password" placeholder="Password">
						<input type="submit" value="Login">
					</form>
				</li>
			</ul>
		</nav>
	</header>
	<h2>Here you can close a reservation</h2>
</body>
</html>
