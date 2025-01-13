package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz03")
public class QuizController {

		@RequestMapping("/main")
		public String main() {
			return "/quiz/main";	
		}
		@RequestMapping("/product/mouse")
		//@RequestMapping(value="/product/mouse",method =RequestMethod.GET)
		public String mouse() {
			return "/quiz/product/mouse";	
		}
		@RequestMapping("/product/keyboard")
		//@GetMapping("/product/keyboard")
		public String keyboard() {
			return "/quiz/product/keyboard";	
		}
		
		@GetMapping("/req1")
		public String req1(HttpServletRequest request) {
			System.out.println(request.getParameter("answer"));
			return "/quiz/req1";
		}
		
		@PostMapping("/req1")
		public String req2(HttpServletRequest request) {
			System.out.println(request.getParameter("answer"));
			return "/quiz/req1";
		}
		
		@RequestMapping("/req2")
		public String req3(HttpServletRequest request) {
			System.out.println(request.getParameter("data1"));
			System.out.println(request.getParameter("data2"));
			return "/quiz/req2";
		}
		
//		@RequestMapping("/req2")
//		public String req4(@RequestParam Map<String,String> reqMap) {
//			System.out.println("/quiz/req2 요청");
//			System.out.println(reqMap.get("data1"));
//			System.out.println(reqMap.get("data2"));
//			return "/quiz/req2";
//		}
		
//		@RequestMapping("/pathA")
//		public String pathA(HttpServletRequest request) {
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("price"));
//			return "/quiz03/pathA";
//		}
//		
//		@RequestMapping("/pathB")
//		public String pathB(HttpServletRequest request) {
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("price"));
//			return "/quiz03/pathB";
//		}
//		@RequestMapping("/pathCommon/A")
//		public String A(HttpServletRequest request) {
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("price"));
//			return "/quiz03/pathCommon/A";
//		}
//		@RequestMapping("/pathCommon/B")
//		public String B(HttpServletRequest request) {
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("price"));
//			return "/quiz03/pathCommon/B";
//		}
		
		
}
