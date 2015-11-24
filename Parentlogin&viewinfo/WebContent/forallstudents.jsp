<%@page import="com.ait.agilebuild.mathrun.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Parent Login Page</title>

<link href="style/parent-login.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
$(function(){
	//adjust pic width by window's width
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>

</head>

<body>
<%
	List<Student> ls = (List)session.getAttribute("stusinfo");
	
%>

<div class="login-box">
	<table>
        	<tr>
            	<td><label>ID:</label><input type="text" name="student_id" value="<%=(ls.get(0)).getId()%>"/></td>
            	<td><label>Name:</label><input type="text" name="student_name" value="<%=(ls.get(0)).getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>Class Name:</label><input type="text" name="class_name" value="<%=(ls.get(0)).getClassName()%>"/></td>
            	<td><label>Teacher:</label><input type="text" name="teacher_name" value="<%=(ls.get(0)).getTeacher().getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>ID:</label><input type="text" name="student_id" value="<%=(ls.get(1)).getId()%>"/></td>
            	<td><label>Name:</label><input type="text" name="student_name" value="<%=(ls.get(1)).getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>Class Name:</label><input type="text" name="class_name" value="<%=(ls.get(1)).getClassName()%>"/></td>
            	<td><label>Teacher:</label><input type="text" name="teacher_name" value="<%=(ls.get(1)).getTeacher().getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>ID:</label><input type="text" name="student_id" value="<%=(ls.get(2)).getId()%>"/></td>
            	<td><label>Name:</label><input type="text" name="student_name" value="<%=(ls.get(2)).getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>Class Name:</label><input type="text" name="class_name" value="<%=(ls.get(2)).getClassName()%>"/></td>
            	<td><label>Teacher:</label><input type="text" name="teacher_name" value="<%=(ls.get(2)).getTeacher().getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>ID:</label><input type="text" name="student_id" value="<%=(ls.get(3)).getId()%>"/></td>
            	<td><label>Name:</label><input type="text" name="student_name" value="<%=(ls.get(3)).getName()%>"/></td>
            </tr>
            <tr>
            	<td><label>Class Name:</label><input type="text" name="class_name" value="<%=(ls.get(3)).getClassName()%>"/></td>
            	<td><label>Teacher:</label><input type="text" name="teacher_name" value="<%=(ls.get(3)).getTeacher().getName()%>"/></td>
            </tr>
        </table>
</div>

<div class="bottom">?2015 Copyright <a href="javascript:;" target="_blank">About us</a> <span>Agile Team A</span></div>



</body>
</html>
