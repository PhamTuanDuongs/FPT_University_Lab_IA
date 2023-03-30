<%-- 
    Document   : login
    Created on : Mar 29, 2023, 5:21:19 PM
    Author     : chuoiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FPT University Academic Portal</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                background-color: #e2e2e2;
                font-family: Arial, Helvetica, sans-serif;
                line-height: 1.8;
                font-size: 14px;
                color: #444444;
            }
            .container {
                background-color: #ffffff;
                margin: 0 auto;
                padding: 60px;
                width: 500px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0,0,0,0.3);
                text-align: center;
            }
            h2 {
                color: #F37022;
                font-size: 30px;
                font-weight: 700;
                margin-bottom: 20px;
            }
            input[type=text], input[type=password] {
                padding: 15px;
                width: 100%;
                border: none;
                border-bottom: 2px solid #004c9e;
                border-radius: 0px;
                margin-bottom: 20px;
                font-size: 16px;
                color: #444444;
                font-weight: 600;
                background-color: #f2f2f2;
                outline: none;
                transition: all .3s ease-in-out;
            }
            input[type=text]:focus, input[type=password]:focus {
                border-bottom: 2px solid #ff6600;
            }
            input[type=submit] {
                background-color: #004c9e;
                color: #ffffff;
                padding: 15px;
                border: none;
                border-radius: 30px;
                cursor: pointer;
                font-size: 16px;
                font-weight: 600;
                transition: all .3s ease-in-out;
            }
            input[type=submit]:hover {
                background-color: #ff6600;
            }
            body {
                background-image: url(../../../resouce/img/san_bong_ro.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <img width="320px" src="../../../resouce/img/logo_fu.png" alt="FPT University logo">
            <h2>FPT University Academic Portal</h2>
            <form action="login" method="post">
                <input type="text" id="username" name="username" placeholder="Username" required><br>
                <input type="password" id="password" name="password" placeholder="Password" required><br>
                <c:if test="${not empty error}">
                    <p style="color:red">${error}</p>
                </c:if>
                <input type="submit" value="LOGIN">
            </form>

    </body>
</html>
