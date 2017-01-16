package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

import junit.framework.Assert;

public class SupplierDAOTestCase {

	@Autowired
	static SupplierDAO supplierDAO;

	@Autowired
	static Supplier supplier;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	// @Test
	public void saveTestCase() {

		supplier.setId("SUP_002");
		supplier.setName("ABC");
		supplier.setAddress("MVM");

		Assert.assertEquals("saveTestCase", true, supplierDAO.addSupplier(supplier));
	}

	@Test

	public void updateTestCase() {
		supplier.setId("SUP_001");
		supplier.setName("SANTOSH");
		supplier.setAddress("MVM");

		Assert.assertEquals("saveTestCase", true, supplierDAO.updateSupplier(supplier));
	}

	@Test
	public void deleteTestCase() {
		supplier.setId("SUP_001");
		supplier.setName("SANTOSH");
		supplier.setAddress("MVM");

		Assert.assertEquals("deleteTestCase", true, supplierDAO.deleteSupplier(supplier));
	}

}
