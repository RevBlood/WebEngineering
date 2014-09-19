<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars in database</title>
</head>
<body>

	<%@ page import="exercise1.*"%>
	<%@	page import="java.util.List"%>
	<%@ page import="java.util.ArrayList" %>
	
	<%@ page import ="javax.servlet.RequestDispatcher" %>
	
	<%
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String type = request.getParameter("Type");
		String workString = request.getParameter("work");
		String search = request.getParameter("search");
		List<String> searchResult = new ArrayList<String>();
		String resultString = "";

		if (search != null) {

			WorkTable table = new WorkTable(search);
			searchResult = table.getWorkTable();

			for (String s : searchResult) {
				resultString += s + "<br>";
			}
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			request.setAttribute("name", resultString);
			rd.forward(request, response);

		} else {

			if (type.equals("Musician")) {
				Album work = new Album(workString);
				Person person = new Person(firstName, lastName, type, work);
				person.addPersonToDatabase();
			} else if (type.equals("Actor")) {
				Movie work = new Movie(workString);
				Person person = new Person(firstName, lastName, type, work);
				person.addPersonToDatabase();
			} else {
			}
		}
	%>
	<jsp:forward page="view.jsp" />
</body>
</html>