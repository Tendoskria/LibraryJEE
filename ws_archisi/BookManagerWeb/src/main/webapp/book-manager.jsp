<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
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
		<nav>
			<ul>
				<li><a href="#">Home</a></li>
				<li>
					<form action="book-manager" method="post">
						<p>
							<c:if test="${not empty sessionScope.LOGIN_INCORRECT}"> 
								${ sessionScope.LOGIN_INCORRECT }
							</c:if>
						</p>
						<input type="text" name="username" placeholder="Username">
						<input type="password" name="password" placeholder="Password">
						<input type="submit" value="Connection">
					</form>
				</li>
			</ul>
		</nav>
	</header>
	<fieldset>
		<table>
			<tr>
				<th>Book</th>
				<th>Author</th>
				<th>Genre</th>
				<th>Available</th>
				<c:forEach items="${requestScope.BOOKS_LIST}" var="book">
					<tr>
						<td>${book.bookTitle}</td>
						<td>${(book.author.firstNameAuthor)}
							${(book.author.lastNameAuthor)}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</fieldset>
</body>
</html>
