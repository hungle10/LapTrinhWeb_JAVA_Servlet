package vn.iotstar.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.dao.ICategoryDAO;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.configs.*;

public class CategoryDAOImpl implements ICategoryDAO{

	public Connection conn= null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		}catch(Exception e)
		{
			
		}
		return null;
	}
	  public static void main(String[] args)
	    {
		  CategoryDAOImpl hh = new CategoryDAOImpl();
		  List<CategoryModel> list =hh.findAll();
	        System.out.println(list);
	    }

	@Override
	public CategoryModel findById(int id) {

			String sql = "select * from categories where categoryid=?";
			List<CategoryModel> list = new ArrayList<>();
			try {
				conn = DBConnectSQLServer.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				while(rs.next())
				{
					CategoryModel category = new CategoryModel();
					category.setCategoryid(rs.getInt("categoryid"));
					category.setCategoryname(rs.getString("categoryname"));
					category.setImages(rs.getString("images"));
					category.setStatus(rs.getInt("status"));
					return category;
				}
				conn.close();
				ps.close();
				rs.close();
			}catch(Exception e)
			{
				
			}
			return null;
	}

	@Override
	public void insert(CategoryModel category) {
		
		String sql = "insert into categories (categoryname,images,status) VALUES (?,?,?)";
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2,category.getImages());
			ps.setInt(3,category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories \r\n"
			    +"SET categoryname=?,images=?,status=?\r\n"
				+"WHERE categoryid=?";
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2,category.getImages());
			ps.setInt(3,category.getStatus());
			ps.setInt(4,category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e)
		{
			
		}
		
	}

	@Override
	public void softdelete(CategoryModel category) {
		String sql = "UPDATE categories \r\n"
			    +"SET status=?\r\n"
				+"WHERE categoryid=?";
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,category.getStatus());
			ps.setInt(2,category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e)
		{
			
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE categories where categoryid=?";
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e)
		{
			
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		String sql = "select * from categories where categoryname like ? ";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = DBConnectSQLServer.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+ keyword +"%");
			rs=ps.executeQuery();
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
			}
			
			conn.close();
			ps.close();
			rs.close();
			
			return list;
		}catch(Exception e)
		{
			
		}
		return null;
	}
	

}
