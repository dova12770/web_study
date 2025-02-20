<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 마이페이지</h1>
	
	<p>아이디 : ${user.id}</p>
	<p>이름 : ${user.name }</p>
	<p>
		<a href="/main">메인화면으로</a>
	</p>
	
	<h3>프로필 사진</h3>
	
	<form action="/customer/profile" method="post" enctype="multipart/form-data">
		<input type="text" name="id">
		<input type="text" name="name">
		<input type="file" name="profileImage">
		<button type="submit">등록</button>
	</form>
</body>
</html>