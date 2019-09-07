<%--
  Created by IntelliJ IDEA.
  User: Jessica
  Date: 2019/8/30
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        input:focus{

            border-style:solid;

            border-color:white;

        }
        form {
            width: 400px;
            height: 240px;
            border: 1px solid #BA4C32;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -120px;
            margin-left: -200px;
            text-align: center;
            color: #BA4C32;
        }
        h2 {
            position: absolute;
            width: 160px;
            height: 40px;
            line-height: 40px;
            top: -60px;
            left: 120px;
            background-color: white;
            font-family:方正兰亭超细黑简体;

        }
        input, select {
            display: block;
            border-radius: 5px;

            border: 1px solid #BA4C32;
            margin: 30px 25px;
            height: 35px;
            font-size: 18px;
            text-indent: 1em;
            width: 350px;
        }
        button {
            width: 100px;
            text-align: center;
            height: 40px;
            line-height: 40px;
            color: white;
            background-color: #BA4C32;
            font-size: 18px;
            border: 0;
            border-radius: 5px;
            margin: 0 auto;
            font-family:方正兰亭超细黑简体;
        }
    </style>
</head>
<body>
<form action="/Blog/loginServlet" method="post">
    <script>confirm("username or password is error")</script>
    <input type="hidden" name="action" value="login">
    <h2>welcome !</h2>
    <input type="text" name="name"  value="${reUser.name}" placeholder="用户名" />
    <input type="password" name="password" placeholder="用户密码" />
    <button type="reset">&nbsp&nbsp reset&nbsp&nbsp&nbsp</button>
    <button type="submit">&nbsp&nbsp login&nbsp&nbsp&nbsp</button>
</form>
</body>
</html>

