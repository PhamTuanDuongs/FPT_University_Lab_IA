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
        <style>

            .row {
                display: flex;
            }
            .left{
                flex: 2;
            }
            .right{
                flex: 3;
            }
            .min-withTd{
                min-width: 130px;
            }
            .term{
                width: 90px;
            }
            td{
                padding: 15px 0;
            }
            ul{
                list-style: none;

            }
            .student-course{
                padding: 15px 0;

            }

            table{
                width: 100%
            }

            td{
                padding: 15px 10px;
            }
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f8f8f8;
            }

            /* Header styles */
            header {
                background-color: #F37022;
                color: #fff;
                padding: 1rem;
                align-items: center;
            }

            /* Main styles */
            main {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                padding: 2rem;
            }

            /* Navigation styles */
            nav {
                background-color: #fff;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                padding: 1rem;
                border-radius: 5px;
            }

            nav ul {
                display: flex;
                flex-direction: column;
            }

            nav li {
                margin: 0.5rem 0;
            }

            nav a {
                color: #124DA3;
                font-size: 1.2rem;
                text-decoration: none;
                transition: color 0.3s ease;
                display: block;
            }

            nav a:hover {
                color: #fff;
                background-color: #124DA3;
                padding: 0.5rem;
                border-radius: 5px;
            }
            .no-color-change {
                color: inherit;
                text-decoration: none;
                white-space: nowrap;
            }

            /* Define styles for the table */
            /* Style for table */
            table {
                border-collapse: collapse;
                margin: 20px auto;
                font-size: 18px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
            }

            th, td {
                padding: 15px 20px;
                text-align: center;
                border: 1px solid #ddd;
            }

            thead {
                background-color: #124DA3;
                color: #fff;
            }

            th:first-child {
                border-top-left-radius: 5px;
            }

            th:last-child {
                border-top-right-radius: 5px;
            }

            td:first-child {
                font-weight: bold;
            }

            /* Style for date input */
            input[type="date"] {
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 8px;
                font-size: 16px;
                margin: 10px;
            }

            /* Style for submit button */
            input[type="submit"] {
                background-color: #124DA3;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 10px 15px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #124DA3;
            }

            /* Style for table rows */
            tbody tr:nth-child(odd) {
                background-color: #f2f2f2;
            }

            /* Style for table slots */
            tbody td {
                font-weight: bold;
            }

            /* Style for empty slots */
            tbody td:empty {
                background-color: #fff;
            }
            a {
                display: inline-block;
                margin-right: 20px;
                margin-bottom: 10px;
                padding: 10px 20px;
                background-color: #124DA3;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s;
            }
            a:hover {
                background-color: #555;
            }
        </style>
    </head>
    <body>

        <header>
            <div style="display: flex; justify-content: center;">
                <a href="/FPT_University_Lab_IA_Group2/student/home" style='background-color: #28a745'>
                    <span>Home</span>
                </a>
                <a href="/FPT_University_Lab_IA_Group2/logout" style='background-color: #28a745'>
                    <span>Logout</span>
                </a>    
                <h1 style="text-align: center; margin-right: 0 20px 0 0; margin-left: auto;">FPT University Academic Portal</h1>
                <h3 style="text-align: right; margin-left: auto;">Welcome ${sessionScope.account.username}</h3>  
            </div>
        </header>
        </br>
        <div class="row">
            <div class="left">
                <table >
                    <thead>
                        <tr>
                            <th scope='col' class="term">Term</th>
                            <th scope='col'>Course</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td valign='center'>
                                <c:forEach items="${semesters}" var="ses">
                                    <div >
                                        <a href="#">${ses.semesterName}</a>
                                    </div>

                                </c:forEach>

                            </td>
                            <td valign='top'>
                                <c:forEach items="${courses}" var="c">
                                    <div >
                                        <input type="hidden" name="courseId" value="${courseId}"/>
                                        <a class="${courseId==c.courseId?"active":""}" href="viewGrade?courseId=${c.courseId}"">  ${c.courseName}</a>
                                    </div>
                                </c:forEach>
                            </td>
                    </tbody>
                </table>

            </div>
        </form>
        <c:if test="${grades.size()>0}">

            <table class='table table-bordered right' >
                <tr>
                <thead>
                <th>GRADE CATEGORY</th>
                <th>GRADE ITEM</th>
                <th>WEIGHT</th>
                <th>VALUE</th>
                <th>COMMENT</th>
                </tr>
                </thead>
                <tbody>

                    <c:set var="isPass" value="true"></c:set>
                    <c:forEach items="${grades}" var="gr">
                        <c:if test="${gr.gradeValue==0}">
                            <c:set var="isPass" value="false"></c:set>

                        </c:if>
                        <tr>
                            <td>${gr.gradeCategory.gradeCategoryName}</td>

                            <td>${gr.gradeCategory.gradeItemName}</td>
                            <td>${gr.gradeCategory.weight}%</td>
                            <td>${gr.gradeValue}</td>
                            <td></td>
                        </tr>                       
                    </c:forEach>
                    <c:if test="${sum<4}"><c:set var="isPass" value="false"></c:set></c:if>
                        </tbody>

                        <tfoot>
                            <tr>
                                <td rowspan="2">Course total</td>
                                <td>Average</td>
                                <td colspan="3">${sum}</td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td colspan="3">
                            <font color="Red"> ${isPass?"Passed":"Not Passed"}</font>


                        </td>
                    </tr>
                </tfoot>

            </table>
        </c:if>

    </div>





</body>
</html>
