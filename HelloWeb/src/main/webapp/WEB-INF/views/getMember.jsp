<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getMember.jsp</title>
</head>
<body>
	<%	
		Employee emp = (Employee) request.getAttribute("empInfo");
		//get Member 건드린 후
//		String empId = request.getParameter("emp_id");
//		EmpDAO dao = new EmpDAO();
//		Employee result = dao.getEmp(Integer.parseInt(empId)); // empId에 값을 받아야하는데 emp_id가 없어서 주소창에 직접 입력 '?emp_id = 사원번호' 검색해보기
	%>
	
	<table border="1">
	<tr>
		<th>사원번호</th>
		<td><%=emp.getEmployeeId() %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=emp.getFirstName() %></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><%=emp.getEmail() %></td>
	</tr>
	</table>
</body>
</html>