package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class ModifyReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 파라미터 받음 (댓글아이디, 변경된 댓글 내용)
		ReplyVO vo = new ReplyVO();
		vo.setReply(req.getParameter("reply"));
		vo.setReplyId(Integer.parseInt(req.getParameter("rid")));
		ReplyService service = new ReplyServiceImpl();
		
		// search.
		boolean result = service.updateReply(vo);
		
		String json = "";
		
		Map<String, Object> map = new HashMap<>();
		
		if(result) {
			vo = service.searchReply(vo.getReplyId());
			map.put("retCode", "Success");
			map.put("data", vo);
		}else {
			map.put("retCode", "Fail");
		}
		
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(map); ///???
		
		return json + ".json";
	}

}
