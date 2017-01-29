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

import com.niit.shoppingcart.dao.ShippingDAO;
import com.niit.shoppingcart.model.Shipping;

@Repository("shippingDAO")
@EnableTransactionManagement
public class ShippingDAOImpl implements ShippingDAO {

	public static Logger log = LoggerFactory.getLogger(ShippingDAOImpl.class);

	@Autowired
	private SessionFactory sessionfactory;

	public ShippingDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addShipment(Shipping shipping) {
		log.debug("Start of the addShipment method");
		sessionfactory.getCurrentSession().saveOrUpdate(shipping);
		log.debug("End of the addShipment method");
	}

	@Transactional
	public Shipping getShipment(String id) {
		log.debug("Start of the getShipment method");
		String hql = "from Shipping where id=" + "'" + id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Shipping> list = (List<Shipping>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		log.debug("End of the getShipment method");
		return null;
	}

	@Transactional
	public List<Shipping> list() {
		log.debug("Start of the List<Shipping> method");
		List<Shipping> list = (List<Shipping>) sessionfactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("End of the List<Shipping> method");
		return list;
	}

}
