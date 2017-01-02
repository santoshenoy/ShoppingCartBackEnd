package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.EmployeeDAO;
import com.niit.shoppingcart.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee = (Employee) context.getBean("employee");

		employee.setId(800);
		employee.setName("SANTOSH12357");
		employee.setAddress("mejeddf5t5");
		employee.setSalary(80000);

		employeeDAO.addEmp(employee);

	}

}
