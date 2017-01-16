package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void getUserTestCase() {
		user = userDAO.get("3");
		Assert.assertNotNull("getUserTestCase", user);

	}

	@Test
	public void validateCredentials() {
		user = userDAO.isValidUser("3", "niit");
		Assert.assertNotNull("validateCredentials", user);
	}

	@Test
	public void invalidateCredentials() {
		user = userDAO.isValidUser("fnejed", "mckdnjef");
		Assert.assertNull("invalidateCredentials", user);

	}

	@Test
	public void getAllUsersTestCase() {
		int size = userDAO.list().size();
		Assert.assertEquals("length check", 3, size);
	}

	@Test
	public void saveTestCase() {
		user.setId("Skmjekd");
		user.setName("mekfnefe");
		user.setMobile("89847484");
		user.setRole("ROLE_USER");
		user.setPassword("fkfjejejed");

		Assert.assertEquals("saveTestCase", true, userDAO.save(user));
	}

	@Test
	public void updateTestCase() {
		user = new User();
		user.setId("Santoshq1e");
		user.setRole("ROLE_USER");
	}

}
