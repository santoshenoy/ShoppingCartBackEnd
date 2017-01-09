package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;

public class CategoryDAOTestCase {

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void saveTestCase() {

		category.setId("CAT_005");
		category.setName("ABCDE");
		category.setDescription("MVFMF");

		Assert.assertEquals("saveTestCase", true, categoryDAO.addCategory(category));
	}

	@Test
	public void updateTestCase() {
		category.setId("CAT_004");
		category.setName("SANTOSH");
		category.setDescription("MVM");

		Assert.assertEquals("saveTestCase", true, categoryDAO.updateCategory(category));
	}

	@Test
	public void deleteTestCase() {
		category.setId("CAT_002");
		category.setName("ABCD");
		category.setDescription("MVFM");

		Assert.assertEquals("deleteTestCase", true, categoryDAO.deleteCategory(category));
	}

}
