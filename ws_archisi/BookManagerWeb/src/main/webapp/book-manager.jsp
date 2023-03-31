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
	<form action="book-manager" method="get">
		<label for="title">Title :</label> <input type="text" id="title"
			name="title" value="${param.title}"> <label for="author">Author
			:</label> <input type="text" id="author" name="author"
			value="${param.author}"> <label for="genre">Genre :</label> <select
			id="genre" name="genre">
			<option value="">-- Select a genre --</option>
			<c:forEach var="genre" items="${requestScope.GENRES_LIST}">
				<option value="${genre.genreName}">${genre.genreName}</option>
			</c:forEach>
		</select> <input type="submit" value="Search">
	</form>
	<c:if test="${not empty requestScope.BOOKS_LIST}">
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
							<td>${(book.genre.genreName)}</td>
							<c:forEach items="${requestScope.BOOKS_AVAILABLE}"
								var="bookAvailable">
								${bookAvailable.bookTitle}
								<c:if test="${bookAvailable.bookTitle == book.bookTitle}">
									<td>Yes</td>
								</c:if>
								<c:if test="${bookAvailable.bookTitle != book.bookTitle}">
									<td>No</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</fieldset>
	</c:if>
	<c:if test="${empty requestScope.BOOKS_LIST}">
		<h2>No book corresponds to your request.</h2>
	</c:if>
	<form action="book-manager" method="get">
		<input type="hidden" name="clear" value="true"> <input
			type="submit" value="Clear filters">
	</form>
</body>
</html>
