package com.yedam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.domain.Employee;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public void close() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//사원 목록
	public List<Employee> getEmpList() {
		conn = DAO.getConnect();
		List<Employee> list = new ArrayList<>();
		Employee emp = null;
		String sql = "SELECT * FROM employees ORDER BY 1 DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setPhone(rs.getString("phone_number"));
				emp.setHiredate(rs.getString("hire_date"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	//사원 조회(단건)
	public Employee getEmp(int empId) {
		conn = DAO.getConnect();
		Employee emp = null;
		String sql = "SELECT * FROM employees WHERE employee_id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setPhone(rs.getString("phone_number"));
				emp.setHiredate(rs.getString("hire_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close();
		}
		return emp;
		
		
	}
	//사원 추가
	public boolean insertEmployee(Employee emp) {
		conn = DAO.getConnect();
		String sql = "INSERT INTO employees (employee_id, first_name ,last_name, email, hire_date, job_id, phone_number) "
				+ " VALUES (EMPLOYEES_SEQ.nextval, ?,?,?,?,?,?)";
		try {
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHiredate());
			psmt.setString(5, emp.getJobId());
			psmt.setString(6, emp.getPhone());
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수: " + r);
			if(r>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	//사원 삭제
	public boolean deleteEmp(String empId) {
		conn = DAO.getConnect();
		String sql = "delete from employees where employee_id = ?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, empId);
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수: " + r);
			if(r>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}
	
	//사원 수정
	public boolean modifyEmp(Employee emp) {
		conn = DAO.getConnect();
		String sql = "UPDATE employees SET first_name=?, last_name=?, email=? WHERE employee_id=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
		
	}
	
}
