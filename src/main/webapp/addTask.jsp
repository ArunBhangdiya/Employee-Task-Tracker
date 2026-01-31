<%--
  Created by IntelliJ IDEA.
  User: arunb
  Date: 31-01-2026
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Add Task</h2>

<form action="addTask" method="post">
    Title: <input type="text" name="title"><br><br>
    Description: <textarea name="description"></textarea><br><br>
    <button type="submit">Add Task</button>
</form>

</body>
</html>

