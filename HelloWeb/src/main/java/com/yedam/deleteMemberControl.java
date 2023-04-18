package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class deleteMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// DB 삭제처리.
		
		String empId = req.getParameter("emp_id");
		
		EmpDAO dao = new EmpDAO();
		try {			
			if(dao.deleteEmp(empId)) {
				resp.sendRedirect("main.do");
			}else {
				resp.sendRedirect("modifyMember.do?emp_id" + empId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
