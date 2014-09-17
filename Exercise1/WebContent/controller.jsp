<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars in database</title>
</head>
<body>

<%@ page import="exercise1.*" %>
<% 
String firstName = request.getParameter("FirstName");
String lastName = request.getParameter("LastName");
String type = request.getParameter("type");
String work = request.getParameter("work");

Person person = new Person(firstName, lastName, type);
person.addPersonToDatabase();
%>
<jsp:forward page="carsindatabase.jsp" /> 
</body>
</html>