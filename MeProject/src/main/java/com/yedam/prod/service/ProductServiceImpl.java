package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.domain.ProductVO;
import com.yedam.prod.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService {
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);

	@Override
	public List<ProductVO> showList() {
		
		return mapper.showList();
	}

	@Override
	public ProductVO searchProd(int prodId) {
		return mapper.searchProd(prodId);

	}
}
