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

import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.model.Payment;

@Repository("paymentDAO")
@EnableTransactionManagement
public class PaymentDAOImpl implements PaymentDAO {

	public static Logger log = LoggerFactory.getLogger(PaymentDAOImpl.class);

	@Autowired
	private SessionFactory sessionfactory;

	public PaymentDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addPayment(Payment payment) {
		log.debug("Start of the addPayment method");
		sessionfactory.getCurrentSession().saveOrUpdate(payment);
		log.debug("End of the getCategory method");
	}

	@Transactional
	public Payment getPayment(String id) {
		log.debug("Start of the getPayment method");
		String hql = "from Payment where id=" + "'" + id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Payment> list = (List<Payment>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		log.debug("End of the getPayment method");
		return null;
	}

	@Transactional
	public List<Payment> list() {
		log.debug("Start of the List<Payment> method");
		List<Payment> list = (List<Payment>) sessionfactory.getCurrentSession().createCriteria(Payment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("End of the List<Payment> method");
		return list;
	}

}
