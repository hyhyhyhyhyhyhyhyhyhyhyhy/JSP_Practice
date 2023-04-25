package com.yedam.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.member.mapper.MemberMapper;

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
			MemberMapper mapper = session.getMapper(MemberMapper.class);
//
//			for (NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
//			}
//		}

			List<Map<String, Object>> list = mapper.memberByDept();
			// 첫데이타부터 [{Administration, 1} {Accounting, 2} ..... {}]
			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet();
				for (String key : set) {
					System.out.println(key + ":" + map.get(key));
				}

			}
		}
	}
}
