package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.models.*;

public interface IUserDAO {
	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);
	
	public UserModel findByUserName(String username);
}
