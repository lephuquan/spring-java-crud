<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
	table {
	border: 1px solid black;
}
</style>
</head>
<body>

	<div class="container">
		<h1 style="text-align: center;">List All News</h1>
		<br />
		<form action="search" method="get">
			<input name="keyword" placeholder="Title, Summary, and category name"
				style="width: 300px"> <input type="submit" value="SEARCH">
		</form>
		<a href="addNews">ADD NEWS</a>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">NEW ID</th>
					<th scope="col">TITLE</th>
					<th scope="col">SUMMARY</th>
					<th scope="col">CREATED DATE</th>
					<th scope="col">STAFF NAME</th>
					<th scope="col">CATE NAME</th>
					<th scope="col">ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${news }" var="n">
					<tr>
						<th scope="row">${n.newId}</th>
						<td>${ n.title}</td>
						<td style="width: 200px">${ n.summary}</td>
						<td>${ n.createdDate}</td>
						<td>${ n.staffsEntity.staffName}</td>
						<td>${ n.categoriesEntity.cateName}</td>
						<td><a href="deleteNews?id=${n.newId}" style="color: red;">DELETE</a>
							<a href="updateNews?id=${n.newId}" style="color: green;">UPDATE</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
