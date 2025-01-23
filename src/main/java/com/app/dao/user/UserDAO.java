package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

public interface UserDAO {
	
	int addUser(User user);
	
	List<User> findUserList();
	
	User findUserById(String id);
	
	public User checkUserLogin(User user);
	
	int modifyUser(User user);
	
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
}
