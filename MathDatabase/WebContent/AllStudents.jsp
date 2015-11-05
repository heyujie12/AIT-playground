<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Students</title>
</head>
<body>
<table border="1">

<td><a href="studentinfo.jsp">Student Info</a></td>
<td><a href="AllStudents.jsp">< All Students</a></td>


</table>

<br />
<h1> List of Students</h1>
<br />

<table border="1">
<th>ID</th>
<th>Name</th>
<th>Age></th>
<th>Class</th>

<c:forEach items="${requestScope.list}" var="student">

<tr>
	<td><a href="./GetStudent?id=${student.idStudents}">${student.idStudents}</a></table></td>
	<td>${student.name}</td>
	<td><${student.age}</td>
	<td><${student.year}</td>
</tr>
</c:forEach>
</body>
</html>