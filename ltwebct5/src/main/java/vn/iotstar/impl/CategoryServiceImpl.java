package vn.iotstar.impl;

import java.util.List;

import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.dao.*;

public class CategoryServiceImpl implements ICategoryService{

	public ICategoryDAO cateDao = new CategoryDAOImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		cateDao.update(category);
		
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
		
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);
	}

	@Override
	public void softdelete(CategoryModel category) {
		cateDao.softdelete(category);
		
	}

}
