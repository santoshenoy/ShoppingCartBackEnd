package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	public boolean addSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

}
