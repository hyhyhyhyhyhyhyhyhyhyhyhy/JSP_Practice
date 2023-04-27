package com.yedam.FrontControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class SearchProdControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codeStr = req.getParameter("code");
		int code = Integer.parseInt(codeStr);
		
		ProductService service = new ProductServiceImpl();	
		ProductVO vo = service.searchProd(code);
		req.setAttribute("detail", vo);
		
		return "prod/prodMain.tiles";
		
		
	}

}
