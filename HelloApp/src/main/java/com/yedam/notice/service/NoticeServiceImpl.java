package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class NoticeServiceImpl implements NoticeService{
	SqlSession session = com.yedam.common.DataSource.getInstance().openSession(true);
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList() {
		return mapper.noticeList();
	}
	@Override
	public boolean addNotice(NoticeVO vo) {
		return mapper.insertNotice(vo)==1;
	}
	@Override
	public boolean modifyNotice(NoticeVO vo) {
		return mapper.updateNotice(vo)==1;
	}
	@Override
	public boolean removeNotice(int NoticeId) {
		return mapper.deleteNotice(NoticeId) == 1;
	}
	@Override
	public NoticeVO getNotice(int NoticeId) {
		return mapper.searchNotice(NoticeId);
	}
	
	

}
