package com.yedam.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.member.domain.MemberVO;
import com.yedam.member.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService {
	SqlSession session = com.yedam.common.DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.loginCheck(vo);
	}

	@Override
	public Map<String, Object> memberByDept() {
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> list = mapper.memberByDept();
		// 첫데이타부터 [{Administration, 1} {Accounting, 2} ..... {}]
		for(Map<String, Object> map : list) {
			System.out.println(map.get("DEPARTMENT_NAME") + ", " + map.get("CNT"));
			result.put((String)map.get("DEPARTMENT_NAME"), map.get("CNT"));
		}
		return result;
	}
}