package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> showList();
	public ProductVO searchProd(int prodId);
	public List<ProductVO> relatedPost();
}
