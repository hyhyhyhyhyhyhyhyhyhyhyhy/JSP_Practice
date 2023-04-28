package com.yedam.FrontControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class ProductAddControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageInfo = "main.do";
		
		ProductService service = new ProductServiceImpl();
		
		if (req.getMethod().equals("GET")) {
			pageInfo = "prod/prodAddForm.tiles";
		}
		
		return pageInfo;
		
		
	}

}
