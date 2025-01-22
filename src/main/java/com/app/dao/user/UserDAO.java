package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserDAO {
	List<User> findUserList();

	int addUser(User user);
	
	User finduserById(String id);
	
	public User checkUserLogin(User user);
}
