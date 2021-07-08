<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>ADD NEWS</h1>
	<h2>${message}</h2>
	
	<form:form  action="postAddNews" modelAttribute="news" method="post">
	
	TITLE  <form:input path="title" type="text"/>
	<form:errors path="title" cssClass="error"></form:errors>
	<br/>
	<br/>
	SUMMARY  <form:input path="summary" type="text"/>
	<form:errors path="summary" cssClass="error"></form:errors>
	<br/>
	<br/>
	CREATED DATE  <form:input path="createdDate" type="date"/>
	<form:errors path="createdDate" cssClass="error"></form:errors>
	<br/>
	<br/>
	STAFF NAME  <form:input path="staffsEntity.staffName" type="text"/>
	<form:errors path="staffsEntity.staffName" cssClass="error"></form:errors>
	<br/>
	<br/>
	CATE NAME  <form:select path="categoriesEntity.cateId">
			<form:option value="0">--select categories name--</form:option>\
			<c:forEach items="${categories}" var="c">
				<form:option value="${c.cateId }">${c.cateName}</form:option>
			</c:forEach>
		</form:select>
	<br/>
	<br/>
	<input type="submit" value="SUBMIT">
	
	</form:form>
	
</div>
</body>
</html>