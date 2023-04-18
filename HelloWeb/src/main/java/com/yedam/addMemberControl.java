package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class addMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 등록처리
		Employee emp = new Employee();

		emp.setFirstName(req.getParameter("fname"));
		emp.setLastName(req.getParameter("lname"));
		emp.setEmail(req.getParameter("email"));
		emp.setJobId(req.getParameter("jobId"));
		emp.setHiredate(req.getParameter("hdate"));
		emp.setPhone(req.getParameter("phone"));
		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);
		if(result) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("addMemberForm.do");
		}

	}

}
