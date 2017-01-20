package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@SuppressWarnings("deprecation")
@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public void deleteCategory(String id) {
		try {
			Category category = new Category();
			category.setId(id);
			sessionFactory.getCurrentSession().delete(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public Category getByName(String name) {
		try {
			String hql = "FROM Category where name='" + name + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list = query.list();
			return list.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
