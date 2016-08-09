<%@ page import="java.util.*,entity.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// JAVA CODE
		// JSP에게 전달된 결과 데이터를 뽑아낼꺼에요
		ArrayList<BoardEntity> list = (ArrayList<BoardEntity>)request.getAttribute("myList");
	%>

	<center>
	<table border = "1">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 작성자</th>
			<th>글 작성일</th>
		</tr>
	<%
		for(int i = 0; i < list.size(); i++){
			BoardEntity tmp = list.get(i);
	%>
		<tr>
			<td><%= tmp.getArticleNum() %></td>
			<td><%= tmp.getArticleTitle() %></td>
			<td><%= tmp.getArticleWriter() %></td>
			<td><%= tmp.getArticleDate() %></td>
		</tr>
	<%
		}
	%>
	</table>
	</center>
</body>
</html>