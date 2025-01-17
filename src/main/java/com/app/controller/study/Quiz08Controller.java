package com.app.controller.study;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Quiz08Controller {

    @GetMapping("/quiz/session/login")
    public String login() {
        return "/quiz/quiz08/session/login"; 
    }

    @PostMapping("/quiz/session/login")
    public String loginAction(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
       

        //id pw <-> 데이터 비교-> 정상인지 체크
        HttpSession session = request.getSession();

        //로그인 성공 이라고 간주!
        if (id != null && !id.isEmpty()) {
            session.setAttribute("loginId", id);
            session.setAttribute("count", 0);
        }
        
        //로그인 후 -> 내가 쓴 게시물
        //DB조회

        return "redirect:/quiz/session/count"; 
    }

    @GetMapping("/quiz/session/count")
    public String count(HttpSession session,Model model) {
    	
    	//로그인 한 상태면> count 증가
    	if(session.getAttribute("loginId")!= null) {
    		//count 값 증가
    		session.setAttribute("count", ((Integer)session.getAttribute("count"))+1);
    	} else {
    		model.addAttribute("count",0);
    	}
    	//로그인 안한 상태면? 접속한 사용자 없음 count 0

//        String loginId = (String) session.getAttribute("loginId");
//        Integer count = (Integer) session.getAttribute("count");
//
//        if (loginId != null) {
//            count = (count == null) ? 1 : count + 1;
//            session.setAttribute("count", count);
//        } else {
//            count = 0;
//        }

//        session.setAttribute("loginId", loginId);
//        session.setAttribute("count", count);

        return "/quiz/quiz08/session/count"; 
    }

    @GetMapping("/quiz/session/logout")
    public String logout(HttpSession session) {
    	
    	//세션에 저장된 정보 삭제
    	//session.removeAttribute("loginId");
    	//session.removeAttribute("count");
    	//초기화
        session.invalidate();

        return "redirect:/quiz/session/count"; 
    }
}

