<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<c:forEach var="notice" items="${list }">
		<tr>
			<td><a href="getNotice.do?nid=${notice.noticeId}">${notice.noticeId}</a></td>
			<td>${notice.noticeTitle }</td>
			<td>${notice.noticeWriter }</td>
			<td>${notice.hitCount}</td>
		</tr>
	</c:forEach>
</table>













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