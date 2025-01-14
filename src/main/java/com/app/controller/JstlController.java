package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.DrinkItem;
import com.app.dto.Member;

@Controller
public class JstlController {
	
	@GetMapping("/jstl1")
	public String jstl1(Model model) {
		
		model.addAttribute("msg","이것은 메시지다");
		
		DrinkItem d1 = new DrinkItem();
		d1.setItem("아메리카노");
		d1.setType("커피");
		
		model.addAttribute("d1",d1);
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("카페라떼","커피"));
		drinkList.add(new DrinkItem("카페모카","커피"));
		drinkList.add(new DrinkItem("카푸치노","커피"));
		drinkList.add(new DrinkItem("아이스티","차"));
		drinkList.add(new DrinkItem("레몬티","차"));
		drinkList.add(new DrinkItem("얼그레이티","차"));
		
		model.addAttribute("drinkList",drinkList);
		model.addAttribute("listSize", drinkList.size());
		
		// ${listSize}
		
		//userType : "user" "admin"
		model.addAttribute("userType","admin");
		
		model.addAttribute("isLogin",true);	//true o false x
		
		return "jstl/jstl1";
	}
	
	@GetMapping("/jstl2")
	public String jstl2(Model model) {
		
		//	안녕하세요~?
		//	안녕하세요~? (*빨간글자)
		//	<span class='fontred'>안녕하세요~?</span>
		
		model.addAttribute("msg1","<부등호>");
		model.addAttribute("msg2","&lt부등호&gt");
		
		model.addAttribute("msgXml","<script>alert('경고')</script>");
		
		return "jstl/jstl2";
	}
	@GetMapping("/jstl/listTest")
	public String listTest(@RequestParam String type, Model model) {
		/*
		model.addAttribute("type",type);
		model.addAttribute("msg","스트링 리스트입니다.");
		
		List<String> msgList = new ArrayList<String>();
		for(int i=1; i<=10; i++)
			msgList.add("스트링 리스트입니다.");
		
		model.addAttribute("msgList",msgList);
		
		List<Member> memberList = new ArrayList<Member>();
		
		for(int i=1; i<=5;i++) {
			memberList.add(new Member("아이디"+i,"비번"+i,"이름"+i));
		}
		
		model.addAttribute("memberList",memberList);
		*/
		model.addAttribute("type",type);
		if(type.equals("str")) {
			model.addAttribute("msg","스트링 리스트입니다.");
			
			List<String> msgList = new ArrayList<String>();
			for(int i=1; i<=10; i++)
				msgList.add("스트링 리스트입니다.");
			
			model.addAttribute("msgList",msgList);
		}
		
		if(type.equals("member")) {
			List<Member> memberList = new ArrayList<Member>();
			
			for(int i=1; i<=5;i++) {
				memberList.add(new Member("아이디"+i,"비번"+i,"이름"+i));
			}
			
			model.addAttribute("memberList",memberList);
		}
		
		
//	public String listTest(Model model) {
//		
//		model.addAttribute("value","스트링 리스트입니다.");
//		model.addAttribute("type","str");
		
//		List<Member> memberList = new ArrayList<Member>();
//		memberList.add(new Member("아이디1","비번1","이름1"));
//		memberList.add(new Member("아이디2","비번2","이름2"));
//		memberList.add(new Member("아이디3","비번3","이름3"));
//		memberList.add(new Member("아이디4","비번4","이름4"));
//		memberList.add(new Member("아이디5","비번5","이름5"));
//		
//		model.addAttribute("memberList",memberList);
//		model.addAttribute("listSize", memberList.size());
//		
//		model.addAttribute("type","member");
		
		
		return "jstl/listTest";
	}
	
}
