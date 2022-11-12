package com.postmeal.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.Model.OrderDetails;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.OrderException;
import com.postmeal.repository.CustomerRepo;
import com.postmeal.repository.OrderDetailsDao;
import com.postmeal.repository.RestaurantRepository;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired	
private OrderDetailsDao orderDao;
@Autowired
private CustomerRepo custRepo;
@Autowired
private RestaurantRepository restRepo;

	

	@Override
	public OrderDetails addOrder(OrderDetails addorders) throws OrderException {
		Optional<OrderDetails> orders= orderDao.findById(addorders.getOrderId());
		if(orders !=null)
		{
			throw new OrderException("Order already Present...!");
			
		}
		
		return orderDao.save(addorders);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails orders) throws OrderException {
		Optional<OrderDetails> updateOrder=orderDao.findById(orders.getOrderId());
		
		if(updateOrder.isPresent())
		{
			return orderDao.save(orders);
			
		}
		else {
			throw new OrderException("Order already Updated..!");
		}
	}

	@Override
	public OrderDetails removeOrder(OrderDetails orders) throws OrderException {
		Optional<OrderDetails> removeOrder=orderDao.findById(orders.getOrderId());
		if(removeOrder.isEmpty())
		{
			throw new OrderException("Nothing in the Oders");
		}
		else {
			orderDao.delete(orders);
			return removeOrder.get();
			
		}
	}

	@Override
	public OrderDetails viewOrder(OrderDetails orders) throws OrderException {
		Optional<OrderDetails>viewOrder= orderDao.findById(orders.getOrderId());
		if(viewOrder.isEmpty())
		{
			throw new OrderException("First Please Add Something");
		}
		else
		{
			return viewOrder.get();
		}
	}

	@Override
	public List<OrderDetails> viewAllOrder() throws OrderException {
		List<OrderDetails> viewallOrder= orderDao.findAll();
		if(viewallOrder.isEmpty())
		{
			throw new OrderException("There is nothing To show");
		}
		return viewallOrder;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Customer cust) throws OrderException {
		List<OrderDetails> viewallorder=orderDao.findAll();
		List<OrderDetails> custOrders= new ArrayList<>();
		if(viewallorder.isEmpty())
		{
			throw new OrderException("Nothing To Show");
		}
	
		for(OrderDetails c: viewallorder)
		{
			if(cust.getEmail().equals(c.getCust().getEmail()))
			{
				custOrders.add(c);
		
			}	
		}
		if(custOrders.isEmpty())
		{
			throw new OrderException("No Order Exist..!!");
		}
		
		return custOrders;
		
	}

}
