package com.postmeal.service;

import java.time.LocalDate;
import java.util.List;

import com.postmeal.Model.Bill;
import com.postmeal.exception.BillException;
import com.postmeal.exception.CustomerException;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill) throws BillException;
	
	public Bill removeBill(Bill bill) throws BillException;
	
	public Bill viewBill(Bill bill) throws BillException;
	
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;
	
	public List<Bill> viewBills(Integer custId) throws BillException,CustomerException;
	
	public Double calculateTotalCost(Bill bill) throws BillException;
}
