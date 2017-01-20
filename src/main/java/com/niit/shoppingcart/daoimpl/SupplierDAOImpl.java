package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
@EnableTransactionManagement
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Supplier get(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public void addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteSupplier(String id) {
		try {
			Supplier supplier = new Supplier();
			supplier.setId(id);
			sessionFactory.getCurrentSession().delete(supplier);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public Supplier getByName(String name) {
		try {
			String hql = "FROM Supplier where name='" + name + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			return list.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
