<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Celebrities</title>
</head>
<body>
<H1>Add new celebrity</H1>

<div style="float:left; width: auto;">
	<form action="controller.jsp" method=post>
	Name: <input type="text" name="FirstName"><br>
	Surname: <input type="text" name="LastName"><br>
	<br>
	<input type="radio" name="Type" value="Musician">Musician<br>
	<input type="radio" name="Type" value="Actor">Actor<br>
	<br>
	
	Works: <input type="text" name="work"><br>
	<br>
	
	<input type="submit" value="Save">
	</form>
	
	<br>
	<br>
	<%@ page import="exercise1.*" %>
	<%@ page import="java.util.List;" %>
	
	<table>
	<%
	PersonTable table = new PersonTable();
	List<Person> personList;
	personList = table.getPersonTable();
	for (Person p : personList) {
	out.print("<tr><td>" + p.getFirstName() + "</td><td>" + p.getLastName() + "</td><td>" + p.getType() + "</td></tr>");
	}
	%>
	</table>
</div>
<div style="float: right; width: auto;">
	<form action="controller.jsp" method=post>
		Search: <input type="text" name="search">
		<input type="submit" value="Search">
	</form>
	<br>
		<table>
	<%
	out.println("<tr><td>");
	out.println(request.getAttribute("name"));
	out.println("</td></tr>");
	%>
	</table>
</div>
</body>

</body>
</html>