package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	// View에서 요청한 method를 구분. GET/POST

		if(req.getMethod().equals("GET")) {
		// emp_id 파라미터.
		// MVC 패턴. 컨트롤러에서 DB의 처리. View 화면으로 정보를 전송
		// emp 변수에 조회결과를 담아서 empInfo의 속성으로 ModifyMember.jsp 재지정.
		String empId = req.getParameter("emp_id");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		req.setAttribute("empInfo", emp);
		
		try {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp");
			rd.forward(req, resp);
		}catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}else if(req.getMethod().equals("POST")) {
		// DB 업데이트 처리. 목록이동.
		Employee emp = new Employee();
		
		String empId = req.getParameter("emp_id");
		String lname = req.getParameter("first_name");
		String fname = req.getParameter("last_name");
		String email = req.getParameter("email");
		
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.modifyEmp(emp);
		
		if(result) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("modifyMember.do");
		}
		
		}
	}
		
	
	
}
