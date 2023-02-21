<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">

<title>목록</title>

</head>
<body>

	<div class="container">
	<br/>
		<h2>게시판</h2>
		<br/>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${list.memberId}</td>
						<td><a href="/board/${list.boardId}">${list.title}</a></td>
						<td>${list.boardDate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" class="btn btn-warning" onclick="location.href='/contentWriteForm';">글쓰기</button>
	</div>

</body>
</html>