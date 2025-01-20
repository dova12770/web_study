package com.app.controller.study.quiz10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.controller.study.quiz10.dto.Quiz10Customer;
import com.app.controller.study.quiz10.service.Quiz10CustomerService;

@Controller
public class Quiz10CustomerController {

	//Quiz10CustomerService
	
	@Autowired
	Quiz10CustomerService quiz10CustmerService;
	
	//등록 페이지 -> get
	@GetMapping("/quiz10registerCustomer")
	public String quiz10registerCustomer() {
		return "quiz/quiz10/quiz10registerCustomer";
	}
	//등록 페이지에서 입력후 등록 요청 -> Post
	@GetMapping("/quiz10registerCustomer")
	public String quiz10registerCustomerAction(Quiz10Customer quiz10Customer) {
		//등록할 화면 입력한 값
		
		//유효성 검증
		//서비스에게 등록 요청
		
		//매개변수로 받은 객체 전달 -> 서비스
		int result = quiz10CustmerService.saveCustomer(quiz10Customer);
		
		if(result > 0) { //저장성공
			//성공시 보여줄 페이지
			return "quiz/quiz10/quiz10registerCustomer";
		} else { //저장실패
			//실패시 보여줄 페이지
			return "quiz/quiz10/quiz10registerCustomer";
		}
	}
}
