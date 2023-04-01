<%-- 
    Document   : student-view-grade
    Created on : Apr 1, 2023, 2:26:38 PM
    Author     : chuoiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:forEach items="${semesters}" var="ses">
            ${ses.semesterName}
        </c:forEach>

        <c:forEach items="${courses}" var="c">
            ${c.courseName}
        </c:forEach>

        <c:forEach items="${requestScope.grades}" var="gr">  
            ${gr.gradeValue} -
            ${gr.gradeCategory.gradeCategoryName} <br>
        </c:forEach>







    </body>
</html>
