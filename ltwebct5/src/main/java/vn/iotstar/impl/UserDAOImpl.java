package vn.iotstar.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.*;
import vn.iotstar.dao.*;
import vn.iotstar.models.UserModel;
public class UserDAOImpl extends DBConnectSQLServer implements IUserDAO{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from userTable";
		List<UserModel> list = new ArrayList<>();
		try
		{
			conn = super.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(
						new UserModel(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("images"),
						rs.getString("fullname")
						)
						);
			}
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int Id) {
		String sql = "SELECT * FROM userTable WHERE id = ?";
		UserModel oneUser = new UserModel();

		try {
		    conn = super.getConnection();
		    ps = conn.prepareStatement(sql);
		    ps.setInt(1,Id); 
		    rs = ps.executeQuery(); 
		    while(rs.next())
			{
		    oneUser.setId(rs.getInt("id"));
		    oneUser.setUsername(rs.getString("username"));
			oneUser.setFullname(rs.getString("fullname"));
            oneUser.setEmail(rs.getString("email"));
            oneUser.setPassword(rs.getString("password"));
            oneUser.setImages(rs.getString("images"));
			}
		    return oneUser;
		    }
		   catch (Exception e) 
		{
		    e.printStackTrace();
		} finally 
		{
		   
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO userTable (username,email,password,images,fullname) VALUES (?,?,?,?,?)";
		try
		{
			conn=super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getImages());
			ps.setString(5,user.getFullname());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[]arg)
	{
		UserDAOImpl userDAO = new UserDAOImpl();
		//userDAO.insert(new UserModel("abc1","abc1@gmail.com","123","linkimage","lethaihung"));
		
		UserModel user = userDAO.findById(1);
		
		
	    System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getImages());
		System.out.println(user.getFullname());
		
		
	}
}

