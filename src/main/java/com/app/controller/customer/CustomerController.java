package com.app.controller.customer;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.ProfileRequestForm;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.dto.user.UserValidError;
import com.app.service.user.UserService;
import com.app.util.LoginManager;
import com.app.validator.USerCustomValidator;
import com.app.validator.UserValidator;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CustomerController {

	@Autowired
	UserService userService;

	// 회원가입
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String signupAction(/*@Valid*/ @ModelAttribute User user, BindingResult br, Model model) {
		
		//별도로 생성한 UserValidError 객체 사용하는 케이스
		UserValidError userVailderror = new UserValidError();
		boolean validResult = USerCustomValidator.validate(user, userVailderror);
		
		if(validResult == false) {//뭔가 걸림
			//유효성 검증 통과 실패
			//저장 진행중지 후 다시 가입페이지로 이동
			model.addAttribute("userVaildError", userVailderror);
			return "customer/signup";
		}
		
		
		/*
		 //BindingResult (Errors) 사용하는 케이스
		//유효성검증!
		USerCustomValidator.validate(user, br);
		
		//유효성 검즌ㅇ 성고 여부                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if(br.hasErrors()) {
			List<ObjectError> errorList = br.getAllErrors();
			for(ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes()[0]);
			}
			
			return "customer/signup";
		}
		*/
//		@InitBinder("user")
//		public void initUserBinder(WebDataBinder binder) {
//			UserValidator validator = new UserValidator();
//			binder.addValidater(validator);
//		}
		
		
		
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.addUser(user);

		System.out.println("회원가입 처리 결과 : " + result);

		if (result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";
		}
	}
	
	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		System.out.println("/customer/checkDupId 요청 들어옴");
		System.out.println(data);
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(data);	//비교할 id
		
		if(result) {
			return "Y";	//중복O -> Y
		} else {
			return "N";	//중복X -> N
		}
		
	//return "ok dupcheckid";
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
								//id : '' type : ''
								//JSON Format Text -> UserDupCheck 객체형태로 파싱
		
		System.out.println("/customer/checkDupId 요청 들어옴");
		System.out.println(userDupCheck);	//data : JSON Format Text -> parse (json-simple, Jackson)
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(userDupCheck.getId());	//비교할 id
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();		
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		apiResponse.setHeader(header);
		
		if(result) {
			apiResponse.setBody("Y");	//중복O -> Y
		} else {
			apiResponse.setBody("N");	//중복X -> N
		}
		
	return apiResponse;
	}

	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}

	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {

		// user id pw 화면으로부터 전달
		// name userType : null

		// user 로그인 할 수 있게 정보가 들어있는지! 확인!
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		if (loginUser == null) { // 아이디X? 아이디O&비번X null
			return "customer/login";
		} else { // 아이디&비번이 맞으면 loginUser
			// 로그인 정보가 맞아서 로그인 성공
			// session.setAttribute("loginUser", loginUser);
			// session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLogin(session, loginUser.getId());

			return "redirect:/main";
		}
	}

	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		LoginManager.logout(session);
		// session.invalidate();

		return "redirect:/main";
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {

		// session 에 loginUserId 값이 존재유무
		// if(session.getAttribute("loginUserId") != null) { //로그인 상태
		if (LoginManager.isLogin(session)) {

			// 로그인되어있는 사용자의 정보를 보여주기
			// User user = userService.findUserById(
			// (String)session.getAttribute("loginUserId") );
			User user = userService.findUserById(LoginManager.getLoginUserId(session));
			model.addAttribute("user", user);

			return "customer/mypage";
		}
		// 로그인 안된 상태
		return "redirect:/customer/login";
	}
	
	/*
	@PostMapping("/customer/profile")
	public String profileAction(HttpServletRequest request, MultipartRequest multipartRequest) {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		
		MultipartFile file = multipartRequest.getFile("profileImage");
		
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.isEmpty());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
		return "redirect:/customer/mypage";
	}
	*/
	@PostMapping("/customer/profile")
	public String profileAction(ProfileRequestForm profileRequestForm) {
		
		System.out.println(profileRequestForm.getId());
		System.out.println(profileRequestForm.getName());
		
		MultipartFile file = profileRequestForm.getProfileImage();
		//첨부파일 수신
		
		//정보확인
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.isEmpty());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
		//1. 파일자체 저장
		/*
		//자체 저장
		try {
		file.transferTo(new File("d:/fileStorage/"+ file.getOriginalFilename()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		//2. 파일 정보를 DB에 저장
		

		
		return "redirect:/customer/mypage";
	}
}
