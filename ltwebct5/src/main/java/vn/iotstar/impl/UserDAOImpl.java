package vn.iotstar.impl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.*;
import vn.iotstar.dao.*;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.*;
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
						rs.getString("fullname"),
						rs.getString("images"),
						Integer.parseInt(rs.getString("roleid")),
						rs.getString("phone"),
						rs.getDate("createDate")
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
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM userTable WHERE email = ?";
		UserModel oneUser = new UserModel();

		try {
		    conn = super.getConnection();
		    ps = conn.prepareStatement(sql);
		    ps.setString(1,email); 
		    rs = ps.executeQuery(); 
		    while(rs.next())
			{
		    	oneUser.setId(rs.getInt("id"));
			    oneUser.setUsername(rs.getString("username"));
				oneUser.setFullname(rs.getString("fullname"));
	            oneUser.setEmail(rs.getString("email"));
	            oneUser.setPassword(rs.getString("password"));
	            oneUser.setImages(rs.getString("images"));
	            oneUser.setRoleid(Integer.parseInt(rs.getString("roleid")));
	            oneUser.setPhone(rs.getString("phone"));
	            oneUser.setCreateDate(rs.getDate("createDate"));
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
	            oneUser.setRoleid(Integer.parseInt(rs.getString("roleid")));
	            oneUser.setPhone(rs.getString("phone"));
	            oneUser.setCreateDate(rs.getDate("createDate"));
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
		String sql = "INSERT INTO userTable (username,email,password,images,fullname,roleid,phone,createDate) VALUES (?,?,?,?,?,?,?,?)";
		try
		{
			conn=super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getImages());
			ps.setString(5,user.getFullname());
			ps.setInt(6,user.getRoleid());
			ps.setString(7,user.getPhone());
			ps.setDate(8,user.getCreateDate());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkExistEmail(String email) {
		String sql = "SELECT * FROM userTable WHERE email = ?";
		boolean duplicate = false;
		try 
		{
		    conn = super.getConnection();
		    ps=conn.prepareStatement(sql);
		    ps.setString(1,email);
		    rs=ps.executeQuery();
		    if(rs.next()) {
		    	duplicate=true;
		    }
		    ps.close();
		    conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}

	

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "SELECT * FROM userTable WHERE username = ?";
		boolean duplicate = false;
		try 
		{
		    conn = super.getConnection();
		    ps=conn.prepareStatement(sql);
		    ps.setString(1,username);
		    rs=ps.executeQuery();
		    if(rs.next()) {
		    	duplicate=true;
		    }
		    ps.close();
		    conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}


	@Override
	public UserModel findByUserName(String username) {
		/*String sql = "SELECT * FROM userTable WHERE username = ?";
		try {
		    conn = super.getConnection();
		    ps = conn.prepareStatement(sql);
		    ps.setString(1,username); 
		    rs = ps.executeQuery(); 
		    while(rs.next())
			{
		    UserModel oneUser = new UserModel();
		    oneUser.setId(rs.getInt("id"));
		    oneUser.setUsername(rs.getString("username"));
			oneUser.setFullname(rs.getString("fullname"));
            oneUser.setEmail(rs.getString("email"));
            oneUser.setPassword(rs.getString("password"));
            oneUser.setImages(rs.getString("images"));
            oneUser.setRoleid(Integer.parseInt(rs.getString("roleid")));
            oneUser.setPhone(rs.getString("phone"));
            oneUser.setCreateDate(rs.getDate("createDate"));
            return oneUser;
			}
		    }
		   catch (Exception e) 
		{
		    e.printStackTrace();
		} finally 
		{

		}
		return null;*/
		String sql = "SELECT * FROM userTable WHERE username = ?";
	    UserModel oneUser = null;
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();

	        while(rs.next()) {
	            oneUser = new UserModel();
	            oneUser.setId(rs.getInt("id"));
	            oneUser.setUsername(rs.getString("username"));
	            oneUser.setFullname(rs.getString("fullname"));
	            oneUser.setEmail(rs.getString("email"));
	            oneUser.setPassword(rs.getString("password"));
	            oneUser.setImages(rs.getString("images"));
	            oneUser.setRoleid(rs.getInt("roleid"));  // Assuming roleid is an integer in the DB
	            oneUser.setPhone(rs.getString("phone"));
	            oneUser.setCreateDate(rs.getDate("createDate"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in reverse order of creation
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return oneUser;
	    
	}

}

