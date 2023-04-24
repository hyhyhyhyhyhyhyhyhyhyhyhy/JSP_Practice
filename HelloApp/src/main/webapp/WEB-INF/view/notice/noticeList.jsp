<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<p>${pageInfo }</p>
	<c:set var="no" value="0"></c:set>
	<table class="table" border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach var="notice" items="${list }">
			<tr>
				<td><c:out value="${no=no+1 }"></c:out></td>
				<td>${notice.noticeId }</td>
				<td><a href="getNotice.do?page=${pageInfo.pageNum}&nid=${notice.noticeId }">${notice.noticeTitle }</a></td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.hitCount }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<div class="center">
		<div class="pagination">
			<c:if test="${pageInfo.prev }">
				<a href="noticeList.do?page=${pageInfo.startPage-1 }">Previous</a>
			</c:if>
			<c:forEach var="i" begin="${pageInfo.startPage }"
				end="${pageInfo.endPage }">
				<a class="${i == pageInfo.pageNum ? 'active' : '' }" href=noticeList.do?page=${i }>${i }</a>
			</c:forEach>
			<c:if test="${pageInfo.next }">
				<a href=noticeList.do?page="${pageInfo.endPage+1 }">Next</a>
			</c:if>
		</div>
	</div>












	<!-- 	<jsp:include page="../main.jsp"></jsp:include>
	<my:if test="${list == null}">
	<p>${list}</p>
	</my:if>
%
for (int i=1;i<=10;i++){
	
}
%
<my:forEach begin="1" end="10" step="2" var="i">
<p>${i}</p>
</my:forEach>

<my:forEach var="notice" items="${list }">
	<p>${notice}</p>
</my:forEach>  -->
</body>
</html>