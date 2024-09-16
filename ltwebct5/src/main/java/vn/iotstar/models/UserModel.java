package vn.iotstar.models;



import java.io.Serializable;
import java.sql.*;


@SuppressWarnings("serial")
public class UserModel implements Serializable{
	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String images;
	private int roleid;
	private String phone;
	private Date createDate;
	public UserModel()
	{
		
	}
	public UserModel(int id,String username, String email, String password, String fullname, String images) {
		super();
		this.id=id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
	}
	public UserModel(String username, String email, String password, String fullname, String images) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
				+ ", createDate=" + createDate + "]";
	}
	public UserModel(String username, String email, String password, String fullname, int roleid, Date createDate) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleid = roleid;
		this.createDate = createDate;
	}
	public UserModel(int id, String username, String email, String password, String fullname, String images, int roleid,
			String phone, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.roleid = roleid;
		this.phone = phone;
		this.createDate = createDate;
	}
	public UserModel(String username, String email, String password, String fullname) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
}
