package com.gha.wa.model.data;

import java.util.List;

import com.gha.wa.model.Withdrawal;

public class WithdrawalService {
	
	private WithdrawalDao withdrawalDao;
	
	public WithdrawalService() {
		withdrawalDao = new WithdrawalDaoImpl();
	}
	
	@SuppressWarnings("unused")
	public void initialize() {
		
		System.out.println("Initializing the data access object");
		withdrawalDao.initialization();
	}
	
	public void saveWorkSheet(List<Withdrawal> withdrwalList) {
		
		System.out.println("Saving worksheet object to database");
		
		for(Withdrawal withdrawal : withdrwalList) {
		
			withdrawalDao.createWithdrawal(withdrawal);
		
		}
		
		System.out.println("Worksheet saved successfully");
	}
	
	@SuppressWarnings("unused")
	public void cleanUp() {
		
		System.out.println("Cleaning up the data access object");
		withdrawalDao.cleaUp();
	}

}
