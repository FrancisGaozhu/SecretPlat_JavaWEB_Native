<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/22
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="alert.jsp"%>
<div id="title"><a href="${pageContext.request.contextPath}/topic/getAll">解忧树洞</a></div>
<div id="userInfo">
    <c:choose>
        <c:when test="${empty sessionScope.loginUser}">
            <a href="${pageContext.request.contextPath}/login.jsp">[请登录]</a>
        </c:when>
        <c:otherwise>
            欢迎&nbsp;<strong>${sessionScope.loginUser.name}</strong>
            匿名状态：
            <c:choose>
                <c:when test="${sessionScope.loginUser.anonymous}">
                    已开启<a onclick="return confirm('是否确定关闭匿名？');" href="${pageContext.request.contextPath}/account/changeAnonymous">[关闭]</a>
                </c:when>
                <c:otherwise>
                    已关闭<a onclick="return confirm('是否确定开启匿名？');" href="${pageContext.request.contextPath}/account/changeAnonymous">[开启]</a>
                </c:otherwise>
            </c:choose>
            <a href="${pageContext.request.contextPath}/account/logout">[注销]</a>
            <a onclick="return deleteConfirm('我确定要删除');" href="${pageContext.request.contextPath}/account/delete">[永久删除账户]</a>
        </c:otherwise>
    </c:choose>
</div>
