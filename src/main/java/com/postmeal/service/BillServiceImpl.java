package com.postmeal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.exception.BillException;
import com.postmeal.exception.CustomerException;
import com.postmeal.model.Bill;
import com.postmeal.repository.BillRepo;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillRepo billRepo;
		
	@Override
	public Bill addBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepo.findById(bill.getBillId());
		if (opt.isPresent()) {
			throw new BillException("Bill generated");
		}

		return billRepo.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepo.findById(bill.getBillId());
		if (opt.isPresent()) {
			
			return billRepo.save(bill);
		}
		else {
			throw new BillException("Bill not Generated");
		}

		
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		Optional<Bill> opt = billRepo.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Generated");
		}

		billRepo.delete(bill);
		return opt.get();
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		Optional<Bill> opt = billRepo.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Generated");
		}

		return opt.get();
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
		List<Bill> li=billRepo.findAll();
	    if(li.size()==0) {
	    	throw new BillException("No Bill between the "+startDate+" and "+endDate);
	    }
	    List<Bill> list=new ArrayList<>();
			for(Bill b:li) {
				if(startDate.isAfter(LocalDate.from(b.getBillDate()))&&endDate.isBefore(LocalDate.from(b.getBillDate()))) {
					list.add(b);
					
				}
				else if(startDate.isEqual(LocalDate.from(b.getBillDate()))||endDate.isEqual(LocalDate.from(b.getBillDate()))) {
					list.add(b);
				}
				
			}
			return list;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException, CustomerException {
		List<Bill> li = billRepo.findAllBybillId(custId);
		if (li.size() == 0) {
			throw new BillException("Bill not Exists with ID"+custId);
		}

		return li;
	}

	@Override
	public Double calculateTotalCost(Bill bill) throws BillException {
		Optional<Bill> opt = billRepo.findById(bill.getBillId());
		if (!opt.isPresent()) {
			throw new BillException("Bill not Found");
		}

		return opt.get().getTotalCost();
	
	}



}
