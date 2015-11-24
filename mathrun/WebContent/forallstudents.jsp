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
	$(function() {
		//adjust pic width by window's width
		var width = $(window).width();
		$(".screenbg ul img").css("width", width + "px");
	});
</script>

</head>

<body>
	<%
		List<Student> ls = (List) session.getAttribute("stusinfo");
		
	%>

	<div class="login-box">
		
		<table width="120%">
			<tr>
				<th>ID</th>
				<th>ClassName</th>
				<th>Name</th>
				<th>Parent Name</th>
				<th>Teacher Name</th>
			</tr>
			<%
				//if (pageCount > 0)
				//	ls.get((curPage - 1) * pageSize + 1);
				for(int i=0; i<ls.size();i++) {
			%>
			<tr align="center">
				<td style="font-size: 16px"><%=(ls.get(i)).getId()%></td>
				<td><%=(ls.get(i)).getClassName()%></td>
				<td><%=(ls.get(i)).getName()%></td>
				<td><%=(ls.get(i)).getParent().getName()%></td>
				<td><%=(ls.get(i)).getTeacher().getName()%></td>
			</tr>
			<%
					
				}
			%>
		</table>
		
	</div>

	<div class="bottom">
		?2015 Copyright <a href="javascript:;" target="_blank">About us</a> <span>Agile
			Team A</span>
	</div>



</body>
</html>
