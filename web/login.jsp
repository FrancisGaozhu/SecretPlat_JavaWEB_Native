<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/22
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/title.css"/>
    <script src="${pageContext.servletContext.contextPath}/js/global.js"></script>
</head>
<body>
<%@include file="/WEB-INF/title.jsp"%>
<form action="${pageContext.servletContext.contextPath}/account/login" method="post">
<table>
    <tr>
        <td>账户名：</td>
        <td><input type="text" name="name" placeholder="请输入用户名"></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" name="password" placeholder="请输入密码"></td>
    </tr>
    <tr>
        <td colspan="2">
            <button type="submit">登录</button>
        </td>
    </tr>
</table>
</form>
[<a href="${pageContext.servletContext.contextPath}/register.jsp">我要注册新账户</a>]
</body>
</html>
