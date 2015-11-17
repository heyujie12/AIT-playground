<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Information</title>
</head>
<body>


<!--<form action="studentinfo.jsp" method="POST">-->
 
 <form action="./StudentServlet" method ="post">
 
 <!--  <table border="1">
 
 <td><a href="studentinfo.jsp">Student Info</a></td>
 <td><a href="AllStudents.jsp">All Students</a></td>
 </table>
 -->
 
<a href="studentinfo.jsp">Student Info</a>
<a href="AllStudents.jsp">All Students</a>

	Student ID:<input type="text" name="id" value="${student.studentID}"/>
	<br>
	Name:<input type="text" name="name" value ="${student.name}"/>
	<br>
	Age:<input type="text" name="age" value = "${student.age}"/>
	<br>
	Class:<input type="text" name="year" value ="${student.year}"/>
	<br>
	<input type="Submit" name="operation" value="Add"/>





	<!--<table border="1">

		<td><a href="studentinfo.jsp">Student Info</a></td>
		<td><a href="AllStudents.jsp">All Students</a></td>

	</table>
	<br />
	
	<form action="./StudentServlet" method=POST>
	
		<table>
		
			<tr>
			<td>Student ID:</td>
			<td><input type ="text" name="id" value=${student.studentID}"></td> 
			</tr>
			<tr>
			<td>Name</td>
			<td><input type ="text" name="name" value=${student.name}"/></td>
			</tr>
			<tr>
			<td>Age</td>
			<td><input type ="text" name="age" value=${student.age}"/></td>
			</tr>
			<tr>
			<td>Class</td>
			<td><input type ="text" name="class" value=${student.year}"/></td>
			</tr>
			<tr>		
			<input type="Submit" name="operation" value="Add"/> 
		</table>-->		
	
	</form>

</body>
</html>