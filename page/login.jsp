<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Custom login page</h2>
	<span><c:out value="${error}"/></span><br>
	<span><c:out value="${logout}"/></span>
	
	<!-- 시큐리티 로그인 작업은 /login에서 이루어짐 -->
	<form action="/login" method="post"><br>

		<!-- csrf 토큰 생성 후 같이 보내기. csrf token : 서버에 들어온 요청이 실제 서버에서 허용한 요청이 맞는지 확인하기 위한 토큰 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
		<!-- input 태그의 속성은 security에 따라 username, password로 지정해야 처리 가능 -->
		<input type="text" name="username" placeholder="ID"><br>
		<input type="password" name="password" placeholder="password">
		
		<input type="submit">
	</form>
	
		<a href="/signUp.do"><button>회원가입</button></a>
	
</body>
</html>