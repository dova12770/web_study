<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<h1>사용자 목록</h1>

	<c:forEach var="user" items="${userList}">
		<p>
		<a href="/admin/user/${user.id}">
			${user.id} ${user.pw} ${user.name}
			<c:choose>
				<c:when test="${user.userType == 'ADM'}">관리자</c:when>
				<c:when test="${user.userType == 'CUS'}">고객사용자</c:when>
			</c:choose>
			<button type="button" onClick="modifyUser('${user.id}')">수정하기</button>
			
		</p>
	</c:forEach>
	
	<script>
	function modifyUser(id){
		location.href = '/admin/modifyUser?id=' + id;
	}
	</script>

</body>
</html>