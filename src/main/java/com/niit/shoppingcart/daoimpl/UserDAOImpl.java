package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@SuppressWarnings("deprecation")
@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		log.debug("List method Started");
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("List method Ends");
		return query.list();
	}

	@Transactional
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Transactional
	public User isValidUser(String id, String password) {
		String hql = "from User where id= '" + id + "'   and password = '" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
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
