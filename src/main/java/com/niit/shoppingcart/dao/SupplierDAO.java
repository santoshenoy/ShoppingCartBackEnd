package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	public Supplier get(String id);

	public void addSupplier(Supplier supplier);

	public void updateSupplier(Supplier supplier);

	public void deleteSupplier(String id);

	public Supplier getByName(String name);

}
