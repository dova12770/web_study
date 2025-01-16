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

	<p>출력 결과 ↓↓↓↓</p>

		<c:if test="${type == 'str'}">
			<c:forEach var="i" begin="1" end="10" step="1">
				<%-- 		<c:forEach var="item" items="${msg}" > --%>
				<p>${msg}</p>
				<!-- 			<p>스트링 리스트입니다.</p> -->
			</c:forEach>
		</c:if>
		
		<c:if test="${type == 'member'}">
			<c:forEach var="Member" items="${memberList}">
				<div>
					<p>${Member.id}${Member.pw}${Member.name}</p>
				</div>
			</c:forEach>
		</c:if>

</body>
</html>