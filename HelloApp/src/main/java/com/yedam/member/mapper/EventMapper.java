package com.yedam.member.mapper;

import java.util.List;

import com.yedam.member.domain.EventVO;

public interface EventMapper {

	// 이벤트 목록
	public List<EventVO> eventList(); // 전체 목록을 다 가져오니까 매개 값 필요없을 듯
	// 이벤트 등록
	public int insertEvent(EventVO event);
	// 이벤트 삭제
	public int deleteEvent(EventVO event);
	
	
	
}
