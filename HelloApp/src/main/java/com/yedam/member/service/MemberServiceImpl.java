package com.yedam.member.service;

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

}
