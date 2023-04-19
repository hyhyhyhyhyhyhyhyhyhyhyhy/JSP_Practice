package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.domain.Employee;
import com.yedam.notice.domain.NoticeVO;

public interface NoticeMapper {
	public Employee getEmp(int empId);
	public List<Employee> empList();
	public int delEmp(int empId);
	public int addEmp(Employee emp);
	// 공지사항.CRUD: 입력, 조회, 수정, 삭제, 목록구현
	public List<NoticeVO> noticeList();
	public int insertNotice(NoticeVO vo);
	public int updateNotice(NoticeVO vo);
	public int deleteNotice(int noticeId);
	public NoticeVO searchNotice(int noticeId);
}
