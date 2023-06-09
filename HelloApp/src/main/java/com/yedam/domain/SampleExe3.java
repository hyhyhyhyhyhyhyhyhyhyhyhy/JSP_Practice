package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe3 {

	public static void main(String[] args) {
//		NoticeService service = new NoticeServiceImpl();
//		
//		for(NoticeVO vo : service.noticeList()) {
//			System.out.println(vo);
//		}
		
		SqlSessionFactory sqlSessionFactory = //
				com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)){
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			
			List<NoticeVO> list = mapper.noticeWithPage(1);
			for(NoticeVO vo : list) {
				System.out.println(vo);
			}
		}
		
		
		
	}
	
	
}
