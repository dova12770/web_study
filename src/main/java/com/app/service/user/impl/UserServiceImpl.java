package com.app.service.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<User> findUserList() {
		List<User> userList = userDAO.findUserList();
		return userList;
	}

	@Override
	public int addUser(User user) {
		int result = userDAO.addUser(user);
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userDAO.addUser(user);
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		int result = userDAO.addUser(user);
		return result;
	}

	@Override
	public User checkUserLogin(User user) {	//로그인 관리자/사용자
		
		//1) 서비스 자체에서 로직을 수행
		User loginUser = userDAO.finduserById(user.getId());
		
		if(loginUser != null && user.getPw().equals(loginUser.getPw())
				&& loginUser.getUserType().equals(user.getUserType())) {	//비밀번호 맞음
			return loginUser;
		}
		
		return null;
		
		// 아이디 & 비번이 맞으면 loginUser
		// 아이디X? 아이디O&비번X null
		
		//int 코드 리턴 -> 1:로그인 성공 2:아이디 o 비밀번호 x 3: 아이디도 없다 4: 휴면계정
		/*
		if(loginUser ==null) { //해당 id에 맞는 계정이 없다
			return null;
		} else {	//해당 id 계정이 있다
			if(user.getPw().equals(loginUser.getPw())) {	//비밀번호 맞음
				return loginUser;
			}
		}
		return null;
		*/
		//2) DAO->Mapper 쿼리를 만들어서 비교하는 방법
		
		
	}

	@Override
	public User finduserById(String id) {
		
		User user = userDAO.finduserById(id);
		return user;
	}

}
