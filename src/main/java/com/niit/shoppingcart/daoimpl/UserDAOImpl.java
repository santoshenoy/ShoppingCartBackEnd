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

@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	public static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		log.debug("Start of the List<User> method");
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of the List<User> method");
		return query.list();
	}

	@Transactional
	public User get(String id) {
		log.debug("Start of the getUser method");
		log.debug("End of the getUser method");
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Transactional
	public User isValidUser(String id, String password) {
		log.debug("Start of the isValidUser method");
		String hql = "from User where id= '" + id + "'   and password = '" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of the isValidUser method");
		return (User) query.uniqueResult();
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		log.debug("Start of the saveOrUpdate method");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("End of the saveOrUpdate method");
		return true;
	}

	@Transactional
	public User getUser(String mail) {

		String hql_string = "FROM User WHERE mail = '" + mail + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		List<User> list = query.list();
		return list.get(0);

		// return (User) sessionFactory.getCurrentSession().get(User.class,
		// mail);
	}

}
