package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.user.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		if(user.getId() == null || user.getId().equals("") || user.getId().trim().length() == 0) {
		    errors.rejectValue("id", "UserIdEmpty","id칸 공란");
		}
		
	}

}
