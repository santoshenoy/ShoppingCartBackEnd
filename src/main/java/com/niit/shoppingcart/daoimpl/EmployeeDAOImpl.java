package com.niit.shoppingcart.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.EmployeeDAO;
import com.niit.shoppingcart.model.Employee;

@Repository("employeeDAO")
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	SessionFactory sessionFactory;

	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addEmp(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

}
