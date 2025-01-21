package com.app.service.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

//	@Override
//	public List<User> findUserList() {
//		List<User> userList = userDAO.findUserList();
//		return userList;
//	}

	@Override
	public int addUser(User user) {
		int result = userDAO.addUser(user);
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		user.setUserType("CUS");
		int result = userDAO.addUser(user);
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		user.setUserType("ADM");
		int result = userDAO.addUser(user);
		return result;
	}

}
