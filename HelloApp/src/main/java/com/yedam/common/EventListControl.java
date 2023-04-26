package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.domain.EventVO;

public class EventListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 이벤트 목록의 결과 값을 반환하는? 메소드?
		String json = "[{\"title\":\"test\", \"startDate\":\"2023-04-05\", \"endDate\":\"2023-04-09\"}]"
			List<EventVO> event = new ArrayList<>();
			
				
		return json + ".json";
		
		
		
	}

}
