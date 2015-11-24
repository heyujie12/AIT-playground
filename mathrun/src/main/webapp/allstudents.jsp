<%@page import="com.ait.agilebuild.mathrun.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.ait.agilebuild.mathrun.impl.MathRunDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Child Info</title>
<link href="style/childinfo.css" type="text/css" rel="stylesheet" />
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
	MathRunDao mrd ;
	List<Student> ls = mrd.getStudents();
	System.out.println(ls);
	
%>
<div class="infobox">
	<form action="" method="post">
    	<table cellpadding="2" cellspacing="2">
        	<tr>
            	<td><label>ID:</label><input type="text" value="<%=(ls.get(0)).getId() %>"/></td>
                <td><label>Name:</label><input type="text" name="student_name"/></td>
            </tr>
            <tr>
            	<td><label>Class Name:</label><input type="text" name="class_name"/></td>
                <td><label>Teacher:</label><input type="text" name="teacher_name"/></td>
            </tr>
            <tr>
            	<td><input type="submit" value="Submit" class="Button"/></td>
                <td><input type="button" value="Log off" class="Button"/></td>
            </tr>
        </table>
    </form>

</div>


<div class="bottom">©2015 Copyright <a href="javascript:;" target="_blank">About us</a> <span>Agile Team A</span></div>

<div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="images/0.jpg"></a></li>
	</ul>
</div>
</body>
</html>
