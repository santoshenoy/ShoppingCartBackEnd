package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public CartDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addCart(Cart cart) {
		sessionfactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public void deleteCart(int id) {
		Cart cart = new Cart();
		cart.setId(id);
		sessionfactory.getCurrentSession().delete(cart);
	}

	@Transactional
	public Cart getCart(String p_id) {
		String hql = "from Cart where u_id=" + "'" + p_id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public List<Cart> list() {
		List<Cart> list = (List<Cart>) sessionfactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Transactional
	public List<Cart> userCartList(String uname) {
		String hql = "from Cart where u_id=" + "'" + uname + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}
}
