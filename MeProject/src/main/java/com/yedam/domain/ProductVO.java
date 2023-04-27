package com.yedam.domain;

import lombok.Data;

@Data
public class ProductVO {
//	PROD_CODE      NOT NULL NUMBER(5)      
//	PROD_NAME      NOT NULL VARCHAR2(50)   
//	PROD_INFO               VARCHAR2(1000) 
//	PROD_PRICE     NOT NULL NUMBER(6)      
//	DISCOUNT_PRICE          NUMBER(6)      
//	REVIEW                  NUMBER(1)      
	
	private int prodCode;
	private String prodName;
	private String prodInfo;
	private int prodPrice;
	private int discountPrice;
	private int review;
	private String image;
	
}
