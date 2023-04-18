<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="menu.jsp"></jsp:include>
    <jsp:include page="nav.jsp"></jsp:include>
    
    
	<form action ="addMember.do">
	<table>
	<tr>
		<th>이름</th>
		<td><input type = "text" name ="fname"></td>
	</tr>
	<tr>
		<th>성</th>
		<td><input type = "text" name ="lname"></td>
	</tr>
	<tr>
		<th>연락처</th>
		<td><input type = "text" name ="phone"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type = "text" name ="email"></td>
	</tr>
	<tr>
		<th>입사일</th>
		<td><input type = "text" name ="hdate"></td>
	</tr>
	<tr>
		<th>업무코드</th>
		<td><input type = "text" name ="jobId"></td>
	</tr>
	</table>
	<input type = "submit" value = "사원 추가">

	</form>	
	
<jsp:include page="footer.jsp"></jsp:include>

