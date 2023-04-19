package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;

public class SampleExe {
	public static void main(String[] args) {
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		String resource = "com/yedam/common/mybatis-config.xml";
		try (SqlSession session = sqlSessionFactory.openSession(true)) { // true를 넣어주면 자동커밋
			  Employee emp = session.selectOne("com.yedam.common.NoticeMapper.getEmp", 100); // 한 건 조회: selectOne 
//			  List<Employee> emp = session.selectList("com.yedam.common.NoticeMapper.empList"); // 다건 조회: selectList
//			session.delete("com.yedam.common.NoticeMapper.delEmp", 217);
			  
			  Employee empl = new Employee();
			  empl.setEmployeeId(301);
			  empl.setLastName("Song");
			  empl.setEmail("son2@email.com");
			  empl.setJobId("IT_PROG");
			  session.insert("com.yedam.common.NoticeMapper.addEmp", empl);
			  List<Employee> emp2 = session.selectList("com.yedam.common.NoticeMapper.empList", 300);
			  System.out.println(emp2);
			}
	}
}
