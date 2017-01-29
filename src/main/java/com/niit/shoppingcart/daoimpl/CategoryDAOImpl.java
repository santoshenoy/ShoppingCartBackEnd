package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {

	public static Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Category get(String id) {
		log.debug("Start of the getCategory method");
		log.debug("End of the getCategory method");
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> list() {
		log.debug("Start of the List<Category> method");
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of the List<Category> method");
		return query.list();
	}

	@Transactional
	public boolean addCategory(Category category) {
		log.debug("Start of the addCategory method");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("End of the addCategory method");
		return true;
	}

	@Transactional
	public boolean updateCategory(Category category) {
		log.debug("Start of the updateCategory method");
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("End of the updateCategory method");
		return true;
	}

	@Transactional
	public void deleteCategory(String id) {
		log.debug("Start of the deleteCategory method");
		try {
			Category category = new Category();
			category.setId(id);
			sessionFactory.getCurrentSession().delete(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("End of the deleteCategory method");
	}

	@Transactional
	public Category getByName(String name) {
		log.debug("Start of the getByName method");
		try {
			String hql = "FROM Category where name='" + name + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list = query.list();
			log.debug("End of the getByName method");
			return list.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
