<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/23
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新账户</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/title.css"/>
    <script src="${pageContext.servletContext.contextPath}/js/global.js"></script>
</head>
<body>
<%@include file="/WEB-INF/title.jsp"%>
<form action="${pageContext.servletContext.contextPath}/account/register" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userPassword" placeholder="请输入登录密码"></td>
        </tr>
        <tr>
            <td>匿名：</td>
            <td>
                <input type="radio" name="anonymous" value="on">开启
                <input type="radio" name="anonymous" value="off" checked>关闭
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">注册</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
