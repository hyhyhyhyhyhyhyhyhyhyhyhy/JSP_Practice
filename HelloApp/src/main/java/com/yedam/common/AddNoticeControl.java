package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일 업로드/db 입력처리/ 목록이동.
		// 멀티파트요청: 요청정보, 저장경로, 최대파일사이즈, 인코딩, 리네임정책인스턴스를 매개값 요청
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, rn);
		
		String writer = multi.getParameter("writer");
		String subject = multi.getParameter("subject");
		String title = multi.getParameter("title");
		String attach = multi.getFilesystemName("attach"); // 바뀐이름으로 넣어야 나중에 찾아올 수 있으므로 변경해서 저장
		
		// 사용자 입력값을 NoticeVO 입력
		NoticeVO vo = new NoticeVO();
		vo.setAttachFile(attach);
		vo.setNoticeSubject(subject);
		vo.setNoticeTitle(title);
		vo.setNoticeWriter(writer);
		
		NoticeService service = new NoticeServiceImpl();
		// 정상처리 >> 목록이동 if not, 메인페이지 이동
		if(service.addNotice(vo)) {
			return "noticeList.do";
		}else {
			return "main.do";
		}
	
	}

}
