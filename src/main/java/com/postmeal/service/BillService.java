package com.postMeal.service;

import java.util.List;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill) throws BillException;
	
	public Bill removeBill(Bill bill) throws BillException;
	
	public Bill viewBill(Bill bill) throws BillException;
	
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;
	
	public List<Bill> viewBills(Integer custId) throws BillException,CustomerException;
	
	public Double calculateTotalCost(Bill bill) throws BillException;
}
