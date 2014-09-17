<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars in database</title>
</head>
<body>
<H1>Cars in database</H1>
<%@ page import="exercise1.*" %>
<%
Car car = new Car();
System.out.println(car.toString());
out.write(car.toHTML());
car.close();
%>
</body>
</html>