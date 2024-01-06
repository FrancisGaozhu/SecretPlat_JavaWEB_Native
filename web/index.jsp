<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/21
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://gaozhu.francis/java8_local_date_time_format" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/title.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topic.css">
    <script src="${pageContext.request.contextPath}/js/global.js"></script>
</head>
<body>
<%@include file="/WEB-INF/title.jsp"%>
<table id="list">
    <c:forEach items="${requestScope.allTopics}" var="topic" varStatus="current">
        <tr>
            <td class="line_count">${current.index + 1}</td>
            <td class="author">
                &lt;
                <c:choose>
                    <c:when test="${topic.account.anonymous}">
                        <strong>匿名</strong>
                    </c:when>
                    <c:otherwise>
                        <strong>${topic.account.name}</strong>
                    </c:otherwise>
                </c:choose>
                &gt;
            </td>
            <td class="title"><%--帖子标题--%><a href="${pageContext.request.contextPath}/topic/loadDetails?id=${topic.id}">${topic.title}</a></td>
            <td class="post_time"><%--发帖时间--%><fmt:LocalDateTimeFormat time="${topic.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td class="delete"><%--删帖入口--%>
                <c:if test="${topic.accountId == sessionScope.loginUser.id}">
                    [<a onclick="return confirm('确定删帖');" href="${pageContext.request.contextPath}/topic/delete?topicId=${topic.id}">删帖</a>]
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <form action="${pageContext.request.contextPath}/topic/newPost" method="post">
            <ul id="post">
                <li><input name="title" type="text" placeholder="请在这里输入新帖子的标题"></li>
                <li>
                    <textarea name="content" id="" cols="30" rows="10" placeholder="请在这里输入帖子的内容"></textarea>
                </li>
                <li>
                    <button type="submit">发布</button>
                </li>
            </ul>
        </form>
    </c:when>
    <c:otherwise>
        <span class="prompt">您需要先登录才能发帖</span>
    </c:otherwise>
</c:choose>
</body>
</html>
