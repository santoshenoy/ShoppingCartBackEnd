package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Payment;

public interface PaymentDAO {

	public void addPayment(Payment payment);

	public Payment getPayment(String id);

	public List<Payment> list();

}
