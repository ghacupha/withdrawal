package com.gha.wa.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Transient;


@Entity
public class MonthlyWithdrawal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String month;
	private double totalWithdrawal;
	
	@Transient
	private Set<Withdrawal> withdrawals;
	
	@Transient
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA");
	/**
	 * @param month
	 * @param withdrawals
	 * @param totalWithdrawal
	 */
	public MonthlyWithdrawal(String month) {
		super();
		System.out.println("Creating :"+month);
		this.month = month;
		this.withdrawals = setWithdrawals(month);
		double totalWithdrawal = setTotalWithdrawal(month);
	}
	

	public int getId() {
		return id;
	}
	public String getMonth() {
		return month;
	}
	public Set<Withdrawal> getWithdrawals() {
		return withdrawals;
	}
	public Set<Withdrawal> setWithdrawals(String month) {
		return getMonthlyWithdrawalSet(month);
	}
	
	private Set<Withdrawal> getMonthlyWithdrawalSet(String month) {
		
		EntityManager em = emFactory.createEntityManager();
		
		System.out.println("Beginning transaction to setWithdrawals for month : "+month);
		Set<Withdrawal> withdrawals = null;
		
		em.getTransaction().begin();
		
		Query query = em.createQuery("SELECT e Withdrawal e WHERE Withdrawal.month = :month",Withdrawal.class);
		
		this.withdrawals = 
				new HashSet<Withdrawal>(query.setParameter("month", month).getResultList());
		
		em.getTransaction().commit();
		
		return withdrawals;		 
	}
	
	public double getTotalWithdrawal() {
		return totalWithdrawal;
	}
	public double setTotalWithdrawal(String month) {
		
		double totalWithdrawal = 0.0;
		
		Set<Withdrawal> monthlyWithdrawals = getMonthlyWithdrawalSet(month);
		
		Iterator<Withdrawal> iter = monthlyWithdrawals.iterator();
		
		while(iter.hasNext()){
			
			Withdrawal withdrawal = iter.next();
			totalWithdrawal += withdrawal.getAmount();
		}
		
		return totalWithdrawal;
	}
	
	
	
}
