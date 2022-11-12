package com.postmeal.service;

import java.util.List;

import com.postmeal.Model.Customer;
import com.postmeal.Model.OrderDetails;
import com.postmeal.exception.OrderException;

public interface OrderService {
	 public OrderDetails addOrder(OrderDetails addorders)throws OrderException;
	 public OrderDetails updateOrder(OrderDetails orders)throws OrderException;
	 public OrderDetails removeOrder(OrderDetails orders)throws OrderException;
	 public OrderDetails viewOrder(OrderDetails orders)throws OrderException;
	 public List<OrderDetails> viewAllOrder()throws OrderException;
	 public List<OrderDetails> viewAllOrder(Customer cust)throws OrderException;
}
