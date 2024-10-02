package vn.iotstar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4238673295544432448L;
	private int categoryid;
    private String categoryname;
    private int status;
    
	private String images;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int categoryid, String categoryname, int status, String images) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.status = status;
		this.images = images;
	}

	public CategoryModel(String categoryname, int status, String images) {
		super();
		this.categoryname = categoryname;
		this.status = status;
		this.images = images;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categoryname=" + categoryname + ", status=" + status
				+ ", images=" + images + "]";
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    

}
