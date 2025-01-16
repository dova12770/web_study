package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.ResponseItem;
import com.app.dto.study.request1DTO;

@Controller
public class Quiz05Controller {

	@RequestMapping("/quiz05/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		return "/quiz/quiz05/request1";	
	}
	
	@RequestMapping("/quiz05/request1-2")
	public String request1_2(@RequestParam String category, @RequestParam String product) {
		System.out.println(category);
		System.out.println(product);
		return "/quiz/quiz05/request1";	
	}
	@RequestMapping("/quiz05/request1-3")
	public String request1_3(@ModelAttribute request1DTO request1Dto) {
		System.out.println(request1Dto.getCategory());
		System.out.println(request1Dto.getProduct());
		return "/quiz/quiz05/request1";	
	}
	@RequestMapping("/quiz05/request1-4")
	public String request1_4(@RequestParam Map<String, String> paramMap) {
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		return "/quiz/quiz05/request1";	
	}
	
	@RequestMapping("/quiz05/response1-1")
	public String response1_1(HttpServletRequest request) {
		request.setAttribute("response001", "message");
		request.setAttribute("response099", "아무거나");
		return "/quiz/quiz05/response1";
	}
	@RequestMapping("/quiz05/response1-2")
	public String response1_2(Model model) {
		model.addAttribute("response001", "message1-2");
		model.addAttribute("response099", "아무거나1-2");
		return "/quiz/quiz05/response1";
	}
	@RequestMapping("/quiz05/response1-3")
	public ModelAndView response1_3() {
		
		ModelAndView mov = new ModelAndView();
		
		mov.setViewName("/quiz/quiz05/response1");
		mov.addObject("response001","message1-3");
		mov.addObject("response099","아무거나1-3");
		
		return mov;
	}
	@RequestMapping("/quiz05/response1-4")
	public String response1_4(@ModelAttribute ResponseItem responseItem) {		//@modelAttribute 어노테이션 생략가능
		System.out.println(responseItem.getResponse001());
		System.out.println(responseItem.getResponse099());
		
		//responseItem.setResponse001("1-4 item 001");
		//responseItem.setResponse099("1-4 객체 099");
		return "/quiz/quiz05/response1";
	}
	
}
