package com.app.validator;

import org.springframework.validation.Errors;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class USerCustomValidator {
	
	public static boolean validate(User user, UserValidError userVaildError) {
		boolean result = true;
		
		if(user.getId() == null || user.getId().equals("") || user.getId().trim().length() == 0) {
			userVaildError.setId("id가 공란입니다");
			result=false;
		}
		if(user.getId().equals("admin")) {
			userVaildError.setId("사용불가능한 id입니다");
			result=false;
		}
		if(user.getPw().length()<8||user.getPw().length()>12) {
			userVaildError.setPw("8~12자리로 입력해주세요");
			result=false;
		}
		
		return result;
	}
	

	public static void validate(User user,Errors errors) {
		if(user.getId() == null || user.getId().equals("") || user.getId().trim().length() == 0) {
		    errors.rejectValue("id", "UserIdEmpty","id칸 공란");
		}
		if(user.getId().equals("admin")) {
			errors.rejectValue("id", "UserIdEmpty","id를 입력해주세요");
		}
		if(user.getPw().length()<8||user.getPw().length()>12) {
			errors.rejectValue("pw", "UserPwSize","8~12자리로 입력해주세요");
		}
	}
	
	public static void validateLoginUser(User user) {
		
	}
	public static void validateAdminUser(User user) {
		
	}
}
