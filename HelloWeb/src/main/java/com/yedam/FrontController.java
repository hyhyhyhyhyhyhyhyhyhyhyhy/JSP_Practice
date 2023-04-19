package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	// key & value 저장할 수 있는 컬렉션. Map
	Map<String, Control> map; 
	
	public FrontController() {
		System.out.println("FrontController() call.");
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() call.");
		map.put("/main.do", new MainControl());
		map.put("/first.do", new FirstControl());
		map.put("/second.do", new SecondControl());
		// 사원정보 상세페이지(getMember.jsp)
		map.put("/getMember.do", new getMemberControl());
		// 사원정보 수정페이지(modifyMember.jsp)
		map.put("/modifyMember.do", new ModifyMemberControl());
		// 등록화면
		map.put("/addMemberForm.do", new addMemberFormControl());
		// 등록처리 > 사원정보DB등록
		map.put("/addMember.do", new addMemberControl());
		// 사원정보 삭제.
		map.put("/deleteMember.do", new deleteMemberControl());
		// 로그인 화면 (아이디/이메일 입력화면)
		map.put("/loginForm.do", new LoginFormControl());
		// 로그인 처리
		map.put("/login.do", new LoginControl());
		// 로그아웃 처리
		map.put("/logout.do", new LogoutControl());
	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 요청정보에 한글: utf-8
		resp.setContentType("text/html;charset=utf-8");
		
		System.out.println("service() call.");
		// http://localhost:8081/HelloWeb/first.do
		String uri = req.getRequestURI(); // 호스트 정보를 제외한 값을 지칭 >>> HelloWeb/first.do 
		String context = req.getContextPath(); // 서블릿에서 context == 프로젝트 이름 (for now /HellowWeb)
		String page = uri.substring(context.length()); // 호출한 값을 페이지로 가져오려고 하는 것
		
		System.out.println(page);
		System.out.println(map.get(page));
		
		Control control = map.get(page);
		control.exec(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() call.");
	}
	
	
	
}
