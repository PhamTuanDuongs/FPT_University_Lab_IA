<%-- 
    Document   : user
    Created on : Mar 28, 2023, 7:05:17 PM
    Author     : chuoiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listAccount}" var="accs">
            ${accs.student.curriculum}
            <br>
        </c:forEach>
    </body>
</html>
