package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
