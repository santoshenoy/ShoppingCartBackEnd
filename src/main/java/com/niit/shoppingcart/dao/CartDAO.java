package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {

	public void addCart(Cart cart);

	public void deleteCart(int id);

	public void deleteCartByUser(String uid);

	public Cart getCart(String p_id);

	public List<Cart> list();

	public List<Cart> userCartList(String uname);

}