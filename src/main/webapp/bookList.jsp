<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>ID</th> 
					<th>TITLE</th> 
					<th>AUTHOR</th>
					<th>ISBN</th>
					<th>GENRE</th>
					<th>CREATED_AT</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="book" items="${bookList}">
				<tr>
					<td>
					 	${book.id}
					 </td>
					<td><a href="getBook.do?title=${book.title}">${book.title}</a></td>
					<td>${book.author}</td>
					<td>${book.isbn}</td>
					<td>${book.genre}</td>
					<td>${book.created_at}</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	</div>
</body>
</html>

































