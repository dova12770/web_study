<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<p>
    <c:choose>
        <c:when test="${loginId != null}">
            		  ${loginId}님이 접속하셨습니다.
        </c:when>
        <c:otherwise>
            접속한 사용자가 없습니다.
        </c:otherwise>
    </c:choose>
</p>

<p>접속 횟수: ${count}</p>

</body>
</html>