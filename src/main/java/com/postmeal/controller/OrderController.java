package com.postmeal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Customer;
import com.postmeal.Model.OrderDetails;
import com.postmeal.exception.OrderException;
import com.postmeal.service.OrderService.OrderService;

@RestController
@RequestMapping("/OrderDetails")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDetails> addOrderHandler(@Valid @RequestBody OrderDetails orders) throws OrderException
	{
		OrderDetails order= orderService.addOrder(orders);
		return new ResponseEntity<OrderDetails>(order,HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrderHandler(@Valid @RequestBody OrderDetails orders) throws OrderException
	
	{
		OrderDetails update = orderService.updateOrder(orders);
		return new ResponseEntity<OrderDetails>(update, HttpStatus.OK);
	}
	@PutMapping("/removeOrder")
	public ResponseEntity<OrderDetails> removeOrderHandler(@Valid @RequestBody OrderDetails orders) throws OrderException
	{
		OrderDetails removeOrder=orderService.removeOrder(orders);
		
		return new ResponseEntity<OrderDetails>(removeOrder,HttpStatus.ACCEPTED);
		
	}
	@PostMapping("/viewOrder")
	public ResponseEntity<OrderDetails> viewOrderHandler(@Valid @RequestBody OrderDetails orders) throws OrderException
	{
		OrderDetails viewOrder=orderService.viewOrder(orders);
		return new ResponseEntity<OrderDetails>(viewOrder,HttpStatus.OK);
	}
	@GetMapping("/viewAllOrder")
 public ResponseEntity<List<OrderDetails>>viewAllOrderHandler(@Valid @RequestBody OrderDetails orders) throws OrderException
 {
	 List<OrderDetails> allOrders=orderService.viewAllOrder();
	
	 return new ResponseEntity<List<OrderDetails>>(allOrders, HttpStatus.OK);
 }
	
	public ResponseEntity<List<OrderDetails>>ViewAllOrderCustomerHandler(@Valid @RequestBody Customer cust) throws OrderException
	{
		List<OrderDetails> custOrders=orderService.viewAllOrder(cust);
		
		return new ResponseEntity<List<OrderDetails>>(custOrders,HttpStatus.OK);
	}
}
