package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.Bmi;

@Controller
public class Quiz04Controller {

	@RequestMapping("quiz04/ask-bmi")
	public String askBmi() {
		return "/quiz/quiz04/ask-bmi";
	}
	
	@RequestMapping("quiz04/result-bmi")
	//public String resultBmi(@ModelAttribute Bmi bmi) {
	public String resultBmi(@RequestParam String name,
			@RequestParam String height, 
			@RequestParam String weight,
			Model model) {
		
		Double heightDB = Double.parseDouble(height);
		Double weightDB = Double.parseDouble(weight);
		
		//double bmi = weightDB/ (heightDB/100)*(heightDB/100);
		double bmi = weightDB/Math.pow(heightDB/100,2);
		
		model.addAttribute("name",name);
		model.addAttribute("height",height);
		model.addAttribute("weight",weight);
		model.addAttribute("bmi",bmi);
		
		return "/quiz/quiz04/result-bmi";
		
	}
	@RequestMapping("quiz04/result-bmi")
	//public String resultBmi(@ModelAttribute Bmi bmi) {
	public String resultBmi2(HttpServletRequest request) {
		
		Double heightDB = Double.parseDouble(request.getParameter("height"));
		Double weightDB = Double.parseDouble(request.getParameter("weight"));
		
		//double bmi = weightDB/ (heightDB/100)*(heightDB/100);
		double bmi = weightDB/Math.pow(heightDB/100,2);
		
		request.setAttribute("name",request.getParameter("name"));
		request.setAttribute("height",request.getParameter("height"));
		request.setAttribute("weight",request.getParameter("weight"));
		request.setAttribute("bmi",bmi);
		
		return "/quiz/quiz04/result-bmi";
		
	}
	@RequestMapping("quiz04/result-bmi")
	//public String resultBmi(@ModelAttribute Bmi bmi) {
	public ModelAndView resultBmi3(@RequestParam Map<String,String> paramMap) {
		
		Double heightDB = Double.parseDouble(paramMap.get("height"));
		Double weightDB = Double.parseDouble(paramMap.get("weight"));
		
		//double bmi = weightDB/ (heightDB/100)*(heightDB/100);
		double bmi = weightDB/Math.pow(heightDB/100,2);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz.quiz04/result-bmi");
		
		mav.addObject("name",paramMap.get("name"));
		mav.addObject("height",paramMap.get("height"));
		mav.addObject("weight",paramMap.get("weight"));
		mav.addObject("bmi",bmi);
		
		return mav;
		
	}
	@RequestMapping("quiz04/result-bmi")
	//public String resultBmi(@ModelAttribute Bmi bmi) {
	public ModelAndView resultBmi4(@RequestParam Map<String,String> paramMap) {
		
		Double heightDB = Double.parseDouble(paramMap.get("height"));
		Double weightDB = Double.parseDouble(paramMap.get("weight"));
		
		//double bmi = weightDB/ (heightDB/100)*(heightDB/100);
		double bmi = weightDB/Math.pow(heightDB/100,2);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz.quiz04/result-bmi");
		
		Bmi bmi1 = new Bmi();
		bmi1.setName(paramMap.get("name"));
		bmi1.setHeight(paramMap.get("height"));
		bmi1.setWeight(paramMap.get("weight"));
		bmi1.setBmi("bmi");
		
		mav.addObject("bmi",bmi1);
		
		return mav;
		
	}
}
