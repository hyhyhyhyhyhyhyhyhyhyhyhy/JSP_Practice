package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.AddReplyControl;
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.ModifyNoticeControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.control.ReplyListControl;

public class FrontController extends HttpServlet {
	String encoding;
	private Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지.
		map.put("/main.do", new MainControl());

		// 공지사항
		map.put("/noticeList.do", new NoticeListControl());
		map.put("/noticeAddForm.do", new NoticeAddForm());
		map.put("/addNotice.do", new AddNoticeControl());
		map.put("/getNotice.do", new GetNoticeControl());
		map.put("/noticeModify.do", new ModifyNoticeControl());

		// 회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		// 댓글정보
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);

		Control control = map.get(path);
		String viewpage = control.execute(req, resp);
		System.out.println(viewpage);

		if (viewpage.endsWith(".do")) {
			resp.sendRedirect(viewpage);
			return;
		}

		if (viewpage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewpage.substring(0, viewpage.length() - 5));
			return;
		}

		// 페이지 재지정
		RequestDispatcher rd = req.getRequestDispatcher(viewpage);
		rd.forward(req, resp);
	}

//		if (viewpage.endsWith(".tiles")) {
//			
//		}

}
