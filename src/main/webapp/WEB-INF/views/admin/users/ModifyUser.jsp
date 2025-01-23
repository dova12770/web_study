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

	<h1>관리자 페이지</h1>
	
		<form action="" method="post">
		<label>아이디<input type="text" name="id" value="${user.id}"></label></br>
		<label>비밀번호<input type="text" name="pw" value="${user.pw}"></label></br>
		<label>이름<input type="text" name="name" value="${user.name}"></label></br>
		
		<h4>관리자권한 설정</h4>
		
		<label>고객<input type="radio" name="userType" value="CUS" <c:if test="${user.userType =='CUS'}"> checked</c:if>></label>
		<label>관리자<input type="radio" name="userType" value="ADM" <c:if test="${user.userType =='ADM'}"> checked</c:if>></label>
		
		<br>
		<button type="submit">사용자 정보 변경</button>
	</form>
</body>
</html>
