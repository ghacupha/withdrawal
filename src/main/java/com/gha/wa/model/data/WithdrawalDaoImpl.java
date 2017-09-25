package com.gha.wa.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gha.wa.model.Withdrawal;

class WithdrawalDaoImpl implements WithdrawalDao{
	
	private EntityManagerFactory emfactory;
	private EntityManager em;
	
	public WithdrawalDaoImpl() {
		
		System.out.println("Creating the data access object : "+this);
		emfactory = Persistence.createEntityManagerFactory("JPA");
	}
	
	@Override
	public void initialization() {
		em = emfactory.createEntityManager();
		
		System.out.println("Beginning batch transactions...");
		em.getTransaction().begin();
	}
	
	public void rollBack() {
		
		rollBack();
	}
	
	public void cleaUp() {
		
		System.out.println("Closing batch transactions...");
		em.getTransaction().commit();
		
		System.out.println("Closing the entity manager factory");
		emfactory.close();
		em.close();
	}

	
	@Override
	public void createWithdrawal(Withdrawal withdrawal) {

		em.persist(withdrawal);
		
		//System.out.println(withdrawal + " saved successfully");
	}

	
	@Override
	public Withdrawal readWithdrawal(int index) {

		Withdrawal withdrawal = new Withdrawal();
		
		withdrawal = em.find(Withdrawal.class, index);
		
		return withdrawal;
		
	}

	
	@Override
	public void updateWithdrawal(int index) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void deleteWithdrawal(int index) {
		// TODO Auto-generated method stub
		
	}
	
	

}
