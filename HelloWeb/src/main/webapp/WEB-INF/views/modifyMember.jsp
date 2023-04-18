<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMember.jsp</title>
</head>
<body>
	<%
	// empList.jsp에서 수정화면으로 이동
	// modifyMember.jsp 값을 변경 
	// 사원번호 조회 >>> Employee
	%>
	
	<%
//		String empId = request.getParameter("emp_id");
//		EmpDAO dao = new EmpDAO();
//		Employee result = dao.getEmp(Integer.parseInt(empId));
		Employee result = (Employee)request.getAttribute("empInfo");
	%>
	
	<form action="modifyMember.do" method="post">
		<table border="1">
		<tr><th>EmployeeId</th><!-- <td><%=result.getEmployeeId() %></td> -->
		<td>
		<input type="text" name = "empId" value="<%=result.getEmployeeId()%>" readonly></td></tr>
		<tr><th>FirstName</th><td>
		<input type="text" name = "first_name" value="<%=result.getFirstName()%>"></td></tr>
		<tr><th>LastName</th><td>
		<input type="text" name = "last_name" value="<%=result.getLastName()%>"></td></tr>
		<tr><th>Email</th><td>
		<input type="text" name = "email" value="<%=result.getEmail()%>"></td></tr>
		</table>
		<input type="submit" value="수정">
		<input type = "button" value = "삭제">
	</form>

<script>
	// Document Object Model.
	let btn = document.querySelector('input[type="button"]');
	console.log(btn);
	btn.onclick = function(){
		alert("클릭됨.");
		let frm = document.querySelector('form');
		frm.action = "deleteMember.do";
		frm.submit(); // 인풋상자의 타입 서밋과 완전히 동일한 기능을 하는 함수
	}
</script>

</body>
</html>