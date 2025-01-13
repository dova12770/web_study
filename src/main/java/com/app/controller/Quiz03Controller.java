package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {

//	@RequestMapping("/pathA")
//	public String pathA() {
//		return "quiz03/pathA";
//	}
//	@RequestMapping("/pathB")
//	public String pathB() {
//		return "quiz03/pathB";
//	}
//	@RequestMapping("/pathCommon/A")
//	public String pathCommonA() {
//		return "quiz03/pathCommon/A";
//	}
//	@RequestMapping("/pathCommon/B")
//	public String pathCommonB() {
//		return "quiz03/pathCommon/B";
//	}
	
	@RequestMapping("/pathA")
	public String pathA() {
		return "quiz03/pathA";
	}
	@RequestMapping("/pathB")
	public String pathB() {
		return "quiz03/pathB";
	}
	@RequestMapping("/pathCommon/A")
	public String pathCommonA(HttpServletRequest request) {
		request.setAttribute("productName", "A라는 상품의 상품명");
		return "quiz03/pathCommon/Common";
	}
	@RequestMapping("/pathCommon/{pathName}")
	public String pathCommonB(@PathVariable String pathName, Model model) {
//		pathname : A B C D ...Z
		
		model.addAttribute("productName", pathName);
		return "quiz03/pathCommon/Common";
	}
	
//	@RequestMapping("/pathA")
//	public String pathA(HttpServletRequest request) {
//		request.setAttribute("productName", "A라는 상품의 상품명");
//		return "quiz03/pathA";
//	}
//	@RequestMapping("/pathB")
//	public String pathB(Model model) {
//		model.addAttribute("productName", "B라는 상품의 상품명");
//		return "quiz03/pathB";
//	}
//	@RequestMapping("/pathCommon/A")
//	public String pathCommonA(HttpServletRequest request) {
//		request.setAttribute("productName", "A라는 상품의 상품명");
//		return "quiz03/pathCommon/Common";
//	}
//	@RequestMapping("/pathCommon/B")
//	public String pathCommonB(Model model) {
//		model.addAttribute("productName", "B라는 상품의 상품명");
//		return "quiz03/pathCommon/Common";
//	}
	
//	@RequestMapping("/pathA")
//	public String pathA(HttpServletRequest request) {
//		request.setAttribute("productName", "A라는 상품의 상품명");
//		return "quiz03/pathA";
//	}
//	@RequestMapping("/pathB")
//	public String pathB(Model model) {
//		model.addAttribute("productName", "B라는 상품의 상품명");
//		return "quiz03/pathB";
//	}
//	@RequestMapping("/pathCommon/A")
//	public String pathCommonA(HttpServletRequest request) {
//		request.setAttribute("productName", "A라는 상품의 상품명");
//		return "quiz03/pathA";
//	}
//	@RequestMapping("/pathCommon/B")
//	public String pathCommonB(Model model) {
//		model.addAttribute("productName", "B라는 상품의 상품명");
//		return "quiz03/pathB";
//	}
	
//	@RequestMapping(value = {"/pathA","/pathCommon/A"})
//	public String pathA(HttpServletRequest request) {
//		request.setAttribute("productName", "A라는 상품의 상품명");
//		return "quiz03/pathA";
//	}
//	@RequestMapping(value = {"/pathA","/pathCommon/B"})
//	public String pathB(Model model) {
//		model.addAttribute("productName", "B라는 상품의 상품명");
//		return "quiz03/pathB";
//	}
}
