package com.yedam.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId);
	// 댓글 등록
	public int insertReply(ReplyVO vo);
	// 댓글 삭제
	public int delReply(ReplyVO vo);
	// public int updateReply(@Param("replyId") int replyId, @Param("reply") String reply); 
	// >> 따로 xml에서 parameterType 지정 안해줘도 됨 
	public int updateReply(ReplyVO vo);
	public ReplyVO searchReply(int replyId);
	
	
	
	
	
}
