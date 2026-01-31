<%--
  Created by IntelliJ IDEA.
  User: arunb
  Date: 31-01-2026
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%
    ResultSet rs = (ResultSet) request.getAttribute("taskList");
%>
<html>
<head>
    <title>View Tasks</title>
</head>
<body>
<h2>All Tasks</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
    </tr>
    <%
        while(rs != null && rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("title") %></td>
        <td><%= rs.getString("description") %></td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="addTask.jsp">Add New Task</a>
</body>
</html>

