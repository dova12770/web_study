package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserService {
	List<User> findUserList();
	
	int addUser(User user);
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
}
