package com.yedam.notice.domain;

import java.util.Date;

import lombok.Data;

@Data

public class ReplyVO {
	
//	REPLY_ID     NOT NULL NUMBER         
//	NOTICE_ID    NOT NULL NUMBER         
//	REPLY        NOT NULL VARCHAR2(1000) 
//	REPLY_WRITER NOT NULL VARCHAR2(50)   
//	REPLY_DATE            DATE       
	
	private int replyId;
	private int noticeId;
	private String reply;
	private String replyWriter;
	private Date replyDate;
}
