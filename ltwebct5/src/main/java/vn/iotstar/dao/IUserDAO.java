package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.models.*;

public interface IUserDAO {
	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);
	
	UserModel findByUserName(String username);
	
	UserModel findByEmail(String email);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
}
