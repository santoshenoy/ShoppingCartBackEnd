package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Shipping;

public interface ShippingDAO {

	public void addShipment(Shipping shipping);

	public Shipping getShipment(String id);

	public List<Shipping> list();

}
