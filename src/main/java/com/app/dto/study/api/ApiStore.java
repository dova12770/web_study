package com.app.dto.study.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiStore {
	String name;	//가게이름
	String address;	//가게주소
	String tel;		//가게 전화번호
}
