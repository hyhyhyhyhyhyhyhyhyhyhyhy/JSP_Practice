package com.yedam.notice.service;

import java.util.List;

import com.yedam.notice.domain.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList(int page);
	public boolean addNotice(NoticeVO vo);
	public boolean modifyNotice(NoticeVO vo);
	public boolean removeNotice(int NoticeId);
	public NoticeVO getNotice(int NoticeId);
	public int totalCount();
}
