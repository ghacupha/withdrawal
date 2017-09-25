package com.gha.wa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.gha.wa.excel.reader.DateUtils;

public class MonthlyWithdrawalManager {	


	private Set<MonthlyWithdrawal> monthlyWithdrawals;
	LocalDate startDate;
	LocalDate endDate;

	
	/**
	 * @param startDate
	 * @param endDate
	 */
	public MonthlyWithdrawalManager(LocalDate startDate, LocalDate endDate) {
		super();
		monthlyWithdrawals = createMonthlyWithdrawals(startDate,endDate);
	}
	
	private Set<MonthlyWithdrawal> createMonthlyWithdrawals(LocalDate startDate, LocalDate endDate){
		
		Set<MonthlyWithdrawal> monthlyWithdrawals = new HashSet<>();
		
		Set<String> monthsUnderAnalysis = monthsUnderAnalysis = monthsUnderAnalysis(startDate, endDate);
		
		Iterator<String> monthlyIter = monthsUnderAnalysis.iterator();
		
		
		while(monthlyIter.hasNext()){
			
			monthlyWithdrawals.add(new MonthlyWithdrawal(monthlyIter.next()));
			
		}

		
		return monthlyWithdrawals;
		
	}
	


	private Set<String> monthsUnderAnalysis(LocalDate startDate, LocalDate endDate){
		
		Set<String> monthsUnderAnalysis = new HashSet<>();
		
		while(startDate.isBefore(endDate)){
			
			monthsUnderAnalysis.add(DateUtils.monthOf(startDate));
			
			startDate.plusMonths(1);
		}
		
		return monthsUnderAnalysis;
		
	}
 
}
