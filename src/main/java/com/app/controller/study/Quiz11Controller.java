package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Quiz11Controller {

	@GetMapping("rest/quiz1")
	public String quiz1() {
		return "rest/quiz";
	}
	
	@ResponseBody
	@GetMapping("rest/quiz2")
	public String quiz2() {
		return "return rest quiz2";
	}
	
	@ResponseBody
	@GetMapping("rest/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;
	}
	
	@ResponseBody
	@GetMapping("/rest/quiz4")
	public String quiz4() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		String jsonStr = null;
		
		ObjectMapper mapper =new ObjectMapper();
		
		try {
			jsonStr = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonStr;
	}
}
