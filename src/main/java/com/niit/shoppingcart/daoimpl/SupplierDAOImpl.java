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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
@EnableTransactionManagement
public class SupplierDAOImpl implements SupplierDAO {

	public static Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Supplier get(String id) {
		log.debug("Start of the getUser method");
		log.debug("End of the getUser method");
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@Transactional
	public List<Supplier> list() {
		log.debug("Start of the List<Supplier> method");
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of the List<Supplier> method");
		return query.list();
	}

	@Transactional
	public void addSupplier(Supplier supplier) {
		log.debug("Start of the addSupplier method");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);

		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("End of the addSupplier method");
	}

	@Transactional
	public void updateSupplier(Supplier supplier) {
		log.debug("Start of the updateSupplier method");
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("End of the updateSupplier method");
	}

	@Transactional
	public void deleteSupplier(String id) {
		log.debug("Start of the deleteSupplier method");
		try {
			Supplier supplier = new Supplier();
			supplier.setId(id);
			sessionFactory.getCurrentSession().delete(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("End of the deleteSupplier method");
	}

	@Transactional
	public Supplier getByName(String name) {
		log.debug("Start of the getByName method");
		try {
			String hql = "FROM Supplier where name='" + name + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			log.debug("End of the getByName method");
			return list.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
