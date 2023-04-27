package com.yedam.prod.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class MainControl implements Control {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService service = new ProductServiceImpl();
		
		List<ProductVO> list = service.showList();
		
		req.setAttribute("list", list);
		
		return "prod/prodList.tiles";
	}

}
