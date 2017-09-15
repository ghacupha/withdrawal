package com.gha.wa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Withdrawal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate date;
	private String accountNumber;
	private String accountName;
	private String currency;
	private double amount;
	/**
	 * @param date
	 * @param accountNumber
	 * @param accountName
	 * @param currency
	 * @param amount
	 */
	public Withdrawal(LocalDate date, String accountNumber, String accountName, String currency, double amount) {
		super();
		this.date = date;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.currency = currency;
		this.amount = amount;
	}
	
	public Withdrawal() {
		
	}
	
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Withdrawal)) {
			return false;
		}
		Withdrawal other = (Withdrawal) obj;
		if (accountName == null) {
			if (other.accountName != null) {
				return false;
			}
		} else if (!accountName.equals(other.accountName)) {
			return false;
		}
		if (accountNumber == null) {
			if (other.accountNumber != null) {
				return false;
			}
		} else if (!accountNumber.equals(other.accountNumber)) {
			return false;
		}
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount)) {
			return false;
		}
		if (currency == null) {
			if (other.currency != null) {
				return false;
			}
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Withdrawal [date=" + date + ", accountNumber=" + accountNumber + ", accountName=" + accountName
				+ ", currency=" + currency + ", amount=" + amount + "]";
	}
	
	

}
