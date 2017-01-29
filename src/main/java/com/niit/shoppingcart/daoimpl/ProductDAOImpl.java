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

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {

	public static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Product get(String id) {
		log.debug("Start of the getProduct method");
		log.debug("End of the getProduct method");
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public List<Product> list() {
		log.debug("Start of the List<Product> method");
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of the List<Product> method");
		return query.list();
	}

	@Transactional
	public boolean addProduct(Product product) {
		log.debug("Start of the addProduct method");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("End of the addProduct method");
		return true;
	}

	@Transactional
	public boolean updateProduct(Product product) {
		log.debug("Start of the updateProduct method");
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("End of the updateProduct method");
		return true;
	}

	@Transactional
	public void deleteProduct(String id) {
		log.debug("Start of the deleteProduct method");
		try {
			Product product = new Product();
			product.setId(id);
			sessionFactory.getCurrentSession().delete(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("End of the deleteProduct method");
	}

}
