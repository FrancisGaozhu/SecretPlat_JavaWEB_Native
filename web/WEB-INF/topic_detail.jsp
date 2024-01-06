<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/24
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://gaozhu.francis/java8_local_date_time_format" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/title.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topic.css">
</head>
<body>
<%@include file="title.jsp" %>
<div class="topic">
    <p class="title">${requestScope.topic.title}</p>
    <p class="content">${requestScope.topic.content}</p>
</div>
<table id="list">
    <c:forEach items="${requestScope.topic.messages}" var="message" varStatus="status">
        <tr>
            <td class="line_count"><%--序号--%>${status.index + 1}</td>
            <td class="author"><%--跟帖人昵称--%>
                <c:choose>
                    <c:when test="${message.account.anonymous}">&lt;匿名&gt;</c:when>
                    <c:otherwise>&lt;${message.account.name}&gt;</c:otherwise>
                </c:choose>
            </td>
            <td class="title"><%--帖子内容--%>${message.content}</td>
            <td class="post_time"><%--跟题时间--%><fmt:LocalDateTimeFormat time="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td class="delete"><%--删帖按钮--%>
                <c:if test="${message.accountId == sessionScope.loginUser.id}">
                    [<a onclick="return confirm('是否确认删除此跟帖？');" href="${pageContext.request.contextPath}/message/delete?messageId=${message.id}&topicId=${requestScope.topic.id}">删除</a>]
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <div class="new_message">
            <form action="${pageContext.request.contextPath}/message/newPost" method="post">
                <ul id="post">
                    <li><input type="hidden" name="topicId" value="${requestScope.topic.id}"></li>
                    <li><textarea name="messageContent" id="" cols="30" rows="10"></textarea></li>
                    <li>
                        <button type="submit">发布</button>
                    </li>
                </ul>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <span class="prompt">您需要先登录才能留言消息</span>
    </c:otherwise>
</c:choose>

</body>
</html>
