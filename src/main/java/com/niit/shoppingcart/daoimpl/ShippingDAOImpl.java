package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ShippingDAO;
import com.niit.shoppingcart.model.Shipping;

@Repository("shippingDAO")
@EnableTransactionManagement
public class ShippingDAOImpl implements ShippingDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public ShippingDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addShipment(Shipping shipping) {
		sessionfactory.getCurrentSession().saveOrUpdate(shipping);
	}

	@Transactional
	public Shipping getShipment(String id) {
		String hql = "from Shipping where id=" + "'" + id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Shipping> list = (List<Shipping>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public List<Shipping> list() {
		List<Shipping> list = (List<Shipping>) sessionfactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
