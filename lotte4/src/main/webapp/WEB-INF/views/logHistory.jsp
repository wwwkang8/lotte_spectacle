<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그이력</title>
</head>
<body>
	<table class="table table-hover">
		<caption><h3>로그인 접속 로그리스트</h3></caption>
		<thead>
			<tr>
				<th class="logIdx">로그 번호</th>
				<th class="logTime">접속시간</th>
				<th class="logId">아이디</th>
				<th class="logName">이름</th>
				<th class="logPhoneNumber">전화번호</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach items="${requestScope.logList }" var="logList">
				<tr>
					<td>${logList.logIdx }</td>
					<td>${logList.logTime}</td>
					<td>${logList.logId}</td>
					<td>${logList.logName}</td>
					<td>${logList.logPhoneNumber}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>