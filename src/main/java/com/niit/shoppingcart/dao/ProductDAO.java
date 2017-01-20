package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();

	public Product get(String id);

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public void deleteProduct(String id);

}
