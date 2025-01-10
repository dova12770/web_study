package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
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
}
