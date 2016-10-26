package com.joyuri.web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyuri.web.DAO.User;
import com.joyuri.web.DAO.UserDAO;

@Service("usersService")
public class UsersService {
	private UserDAO userDao;

	@Autowired
	public void setUsersDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	/* ===================
	 * Creating a new user
	=================== */
	public boolean create(User user) {
		return userDao.create(user);
	}
}
