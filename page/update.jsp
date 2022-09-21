<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="update">
		<form method="post" action="/create.do">
			<input type="text" name="title"/><br><br>
			<input type="text" name="writer"/><br><br>
			<textarea rows="5" cols="40" name="content"></textarea><br><br>
			<button type="submit">작성완료</button>
		</form>
	</div>
</body>
</html>