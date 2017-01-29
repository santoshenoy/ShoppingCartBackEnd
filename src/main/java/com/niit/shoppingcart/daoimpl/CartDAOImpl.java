package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	public static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

	@Autowired
	private SessionFactory sessionfactory;

	public CartDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addCart(Cart cart) {
		log.debug("Start of the addCart method");
		sessionfactory.getCurrentSession().saveOrUpdate(cart);
		log.debug("End of the addCart method");
	}

	@Transactional
	public void deleteCart(int id) {
		log.debug("Start of the deleteCart method");
		Cart cart = new Cart();
		cart.setId(id);
		sessionfactory.getCurrentSession().delete(cart);
		log.debug("End of the deleteCart method");
	}

	@Transactional
	public Cart getCart(String p_id) {
		log.debug("Start of the getCart method");
		String hql = "from Cart where u_id=" + "'" + p_id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		log.debug("End of the getCart method");
		return null;
	}

	@Transactional
	public List<Cart> list() {
		log.debug("Start of the List<Cart> method");
		List<Cart> list = (List<Cart>) sessionfactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("End of the List<Cart> method");
		return list;
	}

	@Transactional
	public List<Cart> userCartList(String uname) {
		log.debug("Start of the userCartList method");
		String hql = "from Cart where u_id=" + "'" + uname + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list;
		}
		log.debug("End of the userCartList method");
		return null;
	}
}
