package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/modifyMemberServlet")
public class ModifyMemberServlet extends HttpServlet {

	// modifyMemberServlet
	// ModifyMemberServlet.java
	// 파라미터 : emp_id, first_name, last_name, email
	// EmpDAO >>> boolean updateMember (Employee) 호출 <<< 이를 위해 form action의 이름과 동일해야함)
	// 처리 : empList.jsp (성공 시)
	//		 modifyMember.jsp 이동 (실패 시)
	
	// 사원 수정
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmpDAO dao = new EmpDAO();
		Employee emp = new Employee();
		
		emp.setFirstName(req.getParameter("first_name"));
		emp.setLastName(req.getParameter("last_name"));
		emp.setEmail(req.getParameter("email"));
		emp.setEmployeeId(Integer.parseInt(req.getParameter("empId")));
		
		boolean r = dao.modifyEmp(emp);
		
		if(r) {
			resp.sendRedirect("empList.jsp");
		}else {
			resp.sendRedirect("modifyMember.jsp");
		}

	
	}
	
}
