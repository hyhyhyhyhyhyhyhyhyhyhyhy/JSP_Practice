package com.yedam.domain;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class Sample4 {
	public static void main(String[] args) {
		ReplyService service = new ReplyServiceImpl();
		List<ReplyVO> list = service.getReplies(100);
		
		for(ReplyVO vo : list) {
			System.out.println(vo);
		}
	}
}
