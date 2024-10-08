package vn.iotstar.impl;


import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

import java.sql.Date;

import vn.iotstar.dao.*;

public class UserServiceImpl implements IUserService {
	
	IUserDAO userDao = new UserDAOImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
		}
	
	@Override
	public boolean register(String email, String password, String username, String fullname) {
		   if (userDao.checkExistUsername(username)) {
			System.out.print("that bai da ton tai username nay ");
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel(username,email,password,fullname,1,date));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public UserModel get(String username) {
		return userDao.findByUserName(username);
	}


	
}
