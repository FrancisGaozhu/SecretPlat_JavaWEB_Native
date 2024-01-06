<%--
  Created by IntelliJ IDEA.
  User: gaozhu
  Date: 2023/11/22
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    <c:if test="${not empty param.alertMessage}">
        alert('${param.alertMessage}');
    </c:if>
    /*
     手动确认删除
     */
    function deleteConfirm(confirmStr) {
        let inputStr = prompt("请在下方输入\"" + confirmStr + "\"");
        if (inputStr === confirmStr)
            return true;
        if (inputStr === null)
            return false;
        alert("内容输入有误，请重新操作！");
        return false;
    }
</script>

