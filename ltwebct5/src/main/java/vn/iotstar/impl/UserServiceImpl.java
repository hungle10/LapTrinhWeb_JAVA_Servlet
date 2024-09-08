package vn.iotstar.impl;


import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
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
	public UserModel get(String username) {
		return userDao.findByUserName(username);
	}


	
}
