package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate(); // 세션 객체의 정보를 삭제처리하겠다.
		
		try {
			resp.sendRedirect("loginForm.do");			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
