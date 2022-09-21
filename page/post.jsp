<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>POST</h2>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<tr>
			<td>${post.boardno}</td>
			<td>${post.writer}</td>
			<td>${post.content}</td>
		</tr>
	</table>
	
	<form action="delete.do" method="post">
		<input type="hidden" value="${vo.boardno}" name="boardno">
		<button>게시글 삭제</button>
	</form>
	<%-- <a href="/update.do?boardno=${vo.boardno}"><button>게시글 수정</button></a> --%>
	<input type="button" value="게시글 수정" onclick="location.href='/update.do?boardno=${update.boardno}'">
</body>
</html>