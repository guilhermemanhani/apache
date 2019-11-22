<%--
  Created by IntelliJ IDEA.
  User: labinfo
  Date: 11/11/2019
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda - criar grupo</title>
</head>
<body>
    <form method="post" action="/groups">
        <label>Descrição</label>
        <input type="text" name="description" id="description">
        <button type="submit">ENVIAR</button>
    </form>
</body>
</html>
