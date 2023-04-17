package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/searchMember")
public class GetMemberServlet extends HttpServlet{
	
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String empId =req.getParameter("emp_id") ;
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		
		if(emp != null) {
			out.print("<table border ='2px' style ='border-collapse:collapse'> ");
			out.print("<tbody>");
			out.print(
					  "<tr>"+ "<th>사번</th><td>"+emp.getEmployeeId()+"</td>"+ "</tr>"
					+ "<tr>"+ "<th>이름</th><td>"+emp.getFirstName()+"</td>" + "</tr>"
					+ "<tr>"+ "<th>성</th><td>"+emp.getLastName()+"</td>" + "</tr>"
					+ "<tr>"+ "<th>이메일</th><td>"+emp.getEmail()+"</td>" + "</tr>"
					+ "<tr>"+ "<th>전화번호</th><td>"+emp.getPhone()+"</td>" + "</tr>"
					+ "<tr>"+ "<th>직무</th><td>"+emp.getJobId()+"</td>" + "</tr>"
					+ "<tr>"+ "<th>입사일</th><td>"+emp.getHiredate()+"</td>" + "</tr>");
			out.print("</tbody>");
			out.print("</table>");
			out.print("<a href ='empList'>목록으로</a>");
		}else {
			
			resp.sendRedirect("employee/employeeForm.html");
			
			
		}
		
	}
}
