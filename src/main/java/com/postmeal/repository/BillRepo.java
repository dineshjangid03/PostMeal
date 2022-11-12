package com.postmeal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.postmeal.Model.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer>{
	
@Query("SELECT b FROM Bill b WHERE b.billDate BETWEEN :sD AND :eD")
	
	public List<Bill> viewBills(@Param("sd") LocalDate startDate,@Param("eD") LocalDate endDate);

	public List<Bill> findAllBybillId(Integer custId);

}
