package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addMemberFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 등록화면 호출		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/addForm.jsp");
		try {
			rd.forward(req, resp); // 페이지 재지정.			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
