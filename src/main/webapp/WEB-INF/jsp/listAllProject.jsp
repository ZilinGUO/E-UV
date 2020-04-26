
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>项目首页</title>
</head>
<body>
<table border="1px" width="100%">
    <tr>
        <td colspan="3" bgcolor="#EEEEEE">所有论坛版块</td>
    </tr>
    <tr>
        <td width="20%">版块名称</td>
        <td width="70%">版块简介</td>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.postName}</td>
            <td>${post.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
