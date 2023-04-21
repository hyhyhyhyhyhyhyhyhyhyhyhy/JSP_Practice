package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageDTO {
	
	// 10페이지씩 끊어서 보여주기
	// 마지막 페이지가 총 페이지보다 크냐 작냐에 따라 출력물 다름
	// 총페이지보다 마지막 
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int pageNum;
	
	public PageDTO(int pageNum, int total) {
		this.pageNum = pageNum;
		
		this.endPage = (int) Math.ceil(this.pageNum/10.0)*10; //올림 메소드 // 들어오는 값이 double 타입이라 10.0으로 나눔 
		this.startPage = this.endPage - 9; 
		
		int realEnd = (int) (Math.ceil(total / 10));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		
		
	}
	
}
