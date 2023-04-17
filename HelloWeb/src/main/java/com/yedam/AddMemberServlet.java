package com.yedam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;



@WebServlet("/addMemberServlet")
public class AddMemberServlet extends HttpServlet{
	//생성자 ,init, service
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee emp = new Employee();

		emp.setFirstName(req.getParameter("fname"));
		emp.setLastName(req.getParameter("lname"));
		emp.setEmail(req.getParameter("email"));
		emp.setJobId(req.getParameter("job"));
		emp.setHiredate(req.getParameter("hire"));
		emp.setPhone(req.getParameter("phone"));
		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);
		if(result) {
			resp.sendRedirect("empList");
		}else {
			resp.sendRedirect("employee/employeeForm.html");
		}
		
	}
	
}
