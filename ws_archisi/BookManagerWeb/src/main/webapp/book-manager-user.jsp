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
			<c:if test="${sessionScope.PRIVILEGE == 'USER'}">
				<form action="log-out-book-servlet" method="get">
					<input type="submit" value="LogOut">
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
	<h2>Here you can find your reservation</h2>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Borrow date</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty requestScope.BORROWS}">
				<c:forEach items="${requestScope.BORROWS}" var="borrow">
					<tr>
						<td>${borrow.getBook().getBookTitle()}</td>
						<td>${borrow.getBook().getAuthor().getfirstNameAuthor()} ${borrow.getBook().getAuthor().getlastNameAuthor()}</td>
						<td>${borrow.getStartingDate()} to ${borrow.getEndingDate()} 
							<c:forEach items="${requestScope.DELAYED_BORROWS}"
								var="delayedBorrow">
								<c:if test="${borrow.getBook().getBookTitle() == delayedBorrow.getBook().getBookTitle()}">
									<p>WARNING, YOU ARE LATE<p>
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>
