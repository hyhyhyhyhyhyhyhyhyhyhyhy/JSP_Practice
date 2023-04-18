<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="menu.jsp"></jsp:include>
    <jsp:include page="nav.jsp"></jsp:include>
	<%
		/* EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList(); */
		List<Employee> list = (List<Employee>) request.getAttribute("listInfo"); // 반환 유형: object
	%>
	<table border="1">
		<thead>
			<tr><th>사원번호</th><th>이름</th><th>이메일</th></tr>
		</thead>
		<tbody>
			<%for (Employee emp : list){ %>
			<tr><td><a href="getMember.do?emp_id=<%=emp.getEmployeeId()%>"><%=emp.getEmployeeId()%></a></td> <!-- 변수의 값을 가져올 때 <%%> 안에 쓰면 됨 -->
				<td><a href="modifyMember.do?emp_id=<%=emp.getEmployeeId()%>"><%=emp.getFirstName() %></a></td>
				<td><%=emp.getEmail() %></td>
			</tr> 
			<% } %>
		</tbody>
	</table>
<jsp:include page="footer.jsp"></jsp:include>