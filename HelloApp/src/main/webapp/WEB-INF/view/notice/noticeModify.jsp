<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>공지사항 수정 페이지(noticeModify.jsp)</h3>

<form action="noticeModify.do" method="post"
	enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid"
				value="${noticeInfo.noticeId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeSubject }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea readonly rows="3" cols="20" name="subject"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter}" readonly></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><c:if
					test="${noticeInfo.attachFile != null && noticeInfo.attachFile != ''}">
				</c:if> <img width="200px" src="images/${noticeInfo.attachFile }"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">저장</button>
				<button type="button">삭제</button>
			</td>
		</tr>
	</table>
</form>
<script>
</script>