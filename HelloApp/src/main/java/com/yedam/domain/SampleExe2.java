package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {

	public static void main(String[] args) {

//		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
//		try (SqlSession session = sqlSessionFactory.openSession()) { 
//			  NoticeMapper mapper = session.getMapper(NoticeMapper.class);
////			  Employee emp = mapper.getEmp(100);
//			  
//			  Employee empl = new Employee();
//			  empl.setEmployeeId(310);
//			  empl.setLastName("Song");
//			  empl.setEmail("son24@email.com");
//			  empl.setJobId("IT_PROG");
//			  
//			  mapper.addEmp(empl);
//			  session.commit();
//			  
//			  Employee emp = mapper.getEmp(310);
//			  System.out.println(emp);
//			}

		// 이게 샘플 1보다 좀 더 자바스러운 느낌

		// com.yedam.notice를 위한 실행문

		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();

		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);

			for (NoticeVO vo : mapper.noticeList()) {
				System.out.println(vo);
			}
		}

	}

}
