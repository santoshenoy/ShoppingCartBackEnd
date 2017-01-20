package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

import junit.framework.Assert;

public class ProductDAOTestCase {

	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	// @Test
	public void saveTestCase() {

		product.setId("SUP_001");
		product.setName("ABC");
		product.setDescription("MVM");
		product.setCategory_id("CAT_004");
		product.setSupplier_id("SUP_002");
		product.setPrice(8347347);
		product.setStock(393);

		Assert.assertEquals("saveTestCase", true, productDAO.addProduct(product));
	}

	// @Test
	public void updateTestCase() {
		product.setId("SUP_001");
		product.setName("ABCD");
		product.setDescription("MVMF");
		product.setCategory_id("CAT_004");
		product.setSupplier_id("SUP_002");
		product.setPrice(8347);
		product.setStock(393);
		Assert.assertEquals("updateTestCase", true, productDAO.updateProduct(product));
	}

	// @Test
	public void deleteTestCase() {
		product.setId("SUP_001");
		product.setName("ABC");
		product.setDescription("MVM");
		product.setCategory_id("CAT_002");
		product.setSupplier_id("SUP_004");
		product.setPrice(8347347);
		product.setStock(393);

		// Assert.assertEquals("deleteTestCase", true,
		// productDAO.deleteProduct(product));
	}

}
