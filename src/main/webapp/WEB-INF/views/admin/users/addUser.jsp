<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	
		<form action="" method="post">
		<label>아이디<input type="text" name="id"></label></br>
		<label>비밀번호<input type="text" name="pw"></label></br>
		<label>이름<input type="text" name="name"></label></br>
		
		<h4>관리자권한 설정</h4>
		
		<select name="userType">
			<option value="ADM">관리자</option>
			<option value="CUS">고객</option>
		</select>
		
		<br>
		<button type="submit">사용자 추가</button>
	</form>
</body>
</html>