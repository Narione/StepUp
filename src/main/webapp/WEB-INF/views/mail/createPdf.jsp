<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdf 생성</title>
</head>
<body>
	<form action="/pdf" method="post">
		<h2>pdf로 전환할 메시지</h2>
		<p>제목: <input type="text" name="title"></p>
		<p>내용:</p>
		<textarea name="content" rows="10" cols="50" style="resize: none;"></textarea>
		<p><input type="submit" value="전환"></p>
	</form>
</body>
</html>