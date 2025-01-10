package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.DrinkItem;

@Controller
//@RequestMapping("/prac01")
public class Practice01Controller {
	@RequestMapping("/prac01/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		return "/prac01/request1";
	}

	@RequestMapping("/prac01/request1-2")
	public String request1_2(@RequestParam String item, @RequestParam String type) {
		System.out.println(item);
		System.out.println(type);
		return "/prac01/request1";
	}

	@RequestMapping("/prac01/request1-3")
	public String request1_3(@RequestParam Map<String, String> paramMap) {
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		return "/prac01/request1";
	}

	@PostMapping("/prac01/request1-4")
//	public String request1_4(@ModelAttribute DrinkItem request) {
	public String request1_4(@ModelAttribute DrinkItem drinkItem) {
		System.out.println(drinkItem.getItem());
		System.out.println(drinkItem.getType());
		return "/prac01/request1";
	}

	@RequestMapping("/prac01/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {

		request.setAttribute("item", "americano");
		request.setAttribute("type", "coffee");
		return "/prac01/viewData1";
	}

	@RequestMapping("/prac01/viewData1-2")
	public String viewData1_2(Model model) {

		model.addAttribute("item", "원조커피");
		model.addAttribute("type", "커피음료");

		return "/prac01/viewData1";
	}

	@RequestMapping("/prac01/viewData1-3")
	public ModelAndView viewData1_3() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/prac01/viewData1");
		
		mav.addObject("item", "커피");
		mav.addObject("type", "커피");
		
		return mav;
	}
	@RequestMapping("/prac01/viewData1-4")
	public String viewData1_4(Model model) {
//		model.addAttribute("item", "원조커피");
//		model.addAttribute("type", "커피음료");
		
		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setItem("유자차");
		drinkItem.setType("차");
		
		model.addAttribute("drinkItem",drinkItem);
	
		return "/prac01/viewData1";
	}
}
