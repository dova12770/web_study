<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requsetParam param1 페이지</h1>

	<div>
	
		<form action="/param2" method="post">
			<input type="text" name="name"><br/>
			<input type="text" name="count"><br/>
			<button type="submit">전송</button>
		</form>

		<a href="/param2?abc=asod&def=123">param2로</a>
	</div>
</body>
</html>