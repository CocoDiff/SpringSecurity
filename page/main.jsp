<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="userTag">
		<a href="/logout">로그아웃</a>
	</div>
	<hr>
	<h2> Main page </h2>
	<a href="create.do"><button id="create">생성</button></a>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
					<td><a href="/viewPost.do?boardno=${vo.boardno}">${vo.boardno}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.content}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>