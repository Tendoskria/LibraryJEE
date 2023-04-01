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
					<input type="submit" value="Profile">
				</form>
			</c:if>
			<c:if test="${sessionScope.PRIVILEGE == 'ADMIN'}">
				<form action="book-manager-admin" method="get">
					<input type="submit" value="Manage">
				</form>
			</c:if>
			<c:if test="${sessionScope.PRIVILEGE == 'ADMIN'}">
				<form action="log-out-book-servlet" method="get">
					<input type="submit" value="LogOut">
				</form>
			</c:if>
		</div>
	</header>
	<h2>Here you can close a reservation</h2>
	<c:if test="${not empty requestScope.BORROWS}">
		<table>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Genre</th>
				<th>Action</th>
			</tr>
			<c:forEach var="borrow" items="${requestScope.BORROWS}">
				<tr>
					<td>${borrow.book.bookTitle}</td>
					<td>${borrow.book.author.firstNameAuthor} ${book.author.firstNameAuthor}</td>
					<td>${borrow.book.genre.genreName}</td>
					<td>
						<form action="book-manager-admin" method="post">
							<input type="hidden" name="idBook" value="${borrow.book.idBook}">
							<input type="submit" value="Return">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
