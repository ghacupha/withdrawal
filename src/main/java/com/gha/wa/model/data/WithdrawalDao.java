package com.gha.wa.model.data;

import com.gha.wa.model.Withdrawal;

public interface WithdrawalDao {
	
	/**
	 * create withdrawal object in database
	 * 
	 * @param withdrawal
	 */
	void createWithdrawal(Withdrawal withdrawal);
	
	/**
	 * Acquires the withdrawal for a given index
	 * 
	 * @param index
	 */
	Withdrawal readWithdrawal(int index);

	/**
	 * Updates a given withdrawal given an index
	 * 
	 * @param index
	 */
	void updateWithdrawal(int index);
	
	/**
	 * Deletes a withdrawal of a given index
	 * 
	 * @param index
	 */
	void deleteWithdrawal(int index);

	/**
	 * Initialize resources
	 */
	void initialization();
	
	/**
	 * Clean up resources
	 */
	void cleaUp();
}
