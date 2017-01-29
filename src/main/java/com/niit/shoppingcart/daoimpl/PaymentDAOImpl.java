package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.model.Payment;

@Repository("paymentDAO")
@EnableTransactionManagement
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public PaymentDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public void addPayment(Payment payment) {
		sessionfactory.getCurrentSession().saveOrUpdate(payment);
	}

	@Transactional
	public Payment getPayment(String id) {
		String hql = "from Payment where id=" + "'" + id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Payment> list = (List<Payment>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public List<Payment> list() {
		List<Payment> list = (List<Payment>) sessionfactory.getCurrentSession().createCriteria(Payment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
