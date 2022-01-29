<%@page import="rakshith.zodiacsign.jsphelper.ZodiacSignJSPHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String zodiac = request.getParameter("zodiac");
    	String message = request.getParameter("message");
    	ZodiacSignJSPHelper zodiacSignJSPHelper = new ZodiacSignJSPHelper(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zodiac Sign</title>
<style type="text/css">
	#zodiac{
		width: 200px;
		height: 200px;
		border: 2px solid black;
	}
</style>
</head>
<body>
	<h2>Zodiac Sign</h2>
	<form name="zodiacForm" method="get" action="ZodiacServlet">
		Month : 
		<select name="month" >
			<% for(int i = 1; i <= 12; i++) {%>
				<option value="<%= i %>" <%= zodiacSignJSPHelper.isSelectedMonth(Integer.toString(i)) %>><%= i %></option>
			<%} %>
		</select><br><br>
		Day : 
		<select name="day">
			<% for(int i = 1; i <= 31; i++) {%>
				<option value="<%= i %>" <%= zodiacSignJSPHelper.isSelectedDay(Integer.toString(i)) %>><%= i %></option>
			<%} %>
		</select>
		<br><br>
		<input type="submit" value="Submit"/><br><br>
		<% if(zodiac != null && !zodiac.equals("null")) {  %>
		Your zodiac sign is 
			<%= zodiac %><br><br>
			<image src = "zodiacsigns/<%=zodiac.toLowerCase()%>.jpg" id="zodiac"></image>
		<%} %>
		<% if(message != null && !message.equals("null")) {  %>
			<%= message %>
		<%} %>
	</form>
	
</body>
</html>