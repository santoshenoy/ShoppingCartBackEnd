package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {

	public List<Category> list();

	public boolean addCategory(Category category);

	public boolean updateCategory(Category category);

	public boolean deleteCategory(Category category);

}
