package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	public UserModel login(String username, String password);
	public UserModel get(String username);
	boolean register(String email, String password, String username, String
			fullname);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);

}
