package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class TestUserDAO {

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@Autowired
	AnnotationConfigApplicationContext context;

	public TestUserDAO() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}

	public boolean validate(String id, String pwd) {
		if (userDAO.validate(id, pwd) == null) {
			System.out.println("User does not exist");
			return false;
		} else {
			System.out.println("User exists");
			return true;
		}
	}

	public static void main(String[] args) {
		TestUserDAO t = new TestUserDAO();
		t.validate("3", "niit");
	}

}
