<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13/3/18
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="messageto">
        <c:out value="${messageto.userFrom.username}"></c:out>
    </c:forEach>
</body>
</html>
