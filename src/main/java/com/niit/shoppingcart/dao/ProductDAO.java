package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public boolean deleteProduct(Product product);

}
