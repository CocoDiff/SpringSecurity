<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Sign Up</h2>
	<form action="signUp.do" method="post">
		<label>아이디</label>
		<input type="text" name="username" placeholder="ID"><br>
		<label>비밀번호</label>
		<input type="password" name="password" placeholder="PW"><br>
		<label>이메일</label>
		<input type="email" name="email" placeholder="email"><br>
		
		<input type="submit"> 
	</form>
</body>
</html>