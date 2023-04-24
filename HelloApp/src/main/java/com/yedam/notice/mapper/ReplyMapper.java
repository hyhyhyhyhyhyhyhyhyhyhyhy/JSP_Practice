package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId);
	// 댓글 등록
	public int insertReply(ReplyVO vo);
	// 댓글 삭제
	public int delReply(ReplyVO vo);
	
	
	
	
	
}
