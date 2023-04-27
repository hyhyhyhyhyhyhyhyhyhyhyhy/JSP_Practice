package com.yedam.prod.service;

import java.util.List;

import com.yedam.domain.ProductVO;

public interface ProductService {
	// 상품 전체 조회
	public List<ProductVO> showList();
	// 상품 상세 조회(클릭 시)
	public ProductVO searchProd(int prodId);
}
