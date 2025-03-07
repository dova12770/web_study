package com.app.scheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.dto.user.User;
import com.app.service.user.UserService;

public class MyScheduler {
	
	@Autowired
	UserService userService;
	//@Scheduled(cron = "0/5 * * * * *")
	@Scheduled(cron = "0 0 3 * * *")
	public void schduler() {
		System.out.println("schedule " + LocalDate.now());
		
		//api 요청
		//외부 공공데이터 API 요청 -> Service 데이터 획득
		
		//api 요청 데이터 DB 저장
		//apidata 테이블 -> insert 저장 (apidataDAO)
		
		User user = userService.findUserById("stella");
		System.out.println(user);
	}
}
