package com.yedam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 전체 생성자를 다 만들어주는 기능
@NoArgsConstructor
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	
}
