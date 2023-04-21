package com.yedam.notice.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class GetNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param: nid
		// 조회된 결과값을 리턴하는 페이지로 넘김
		
		String nid = req.getParameter("nid");
		String page = req.getParameter("page");
		
		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = service.getNotice(Integer.parseInt(nid));
		req.setAttribute("noticeInfo", vo);
		req.setAttribute("pageNum", page);
		
		// 첨부파일이 있으면?
		if(vo.getAttachFile() != null) {
			String imgPath = req.getServletContext().getRealPath("images");
			Path file = Paths.get(imgPath + "/" + vo.getAttachFile());
			System.out.println("Files.probeContentType(file)");
			
			// image/jpg, image/png, text/plain 이미지인지 텍스트인지 구분하기 위해
			String fileType = Files.probeContentType(file);
			req.setAttribute("fileType", fileType.substring(0, fileType.indexOf("/"))); // 첫글자부터 슬래쉬 값이 있는 위치까지 검색 후 가지고 온다. image or text 가릴 수 있음
		}
		
		return "notice/noticeGet.tiles";
	}

}
