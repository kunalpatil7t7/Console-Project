package com.console.bank.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transaction {

	private LocalDateTime Timestamp;
	private String ssenderId;
	private Double transactionAmount;
	private String transactionType;
	private Double initialBalance;
	private Double finalBalance;
	private String transactionperformedby;
	
	
	public Transaction(LocalDateTime timestamp, String ssenderId, Double transactionAmount, String transactionType,
			Double initialBalance, Double finalBalance, String transactionperformedby) {
		super();
		Timestamp = timestamp;
		this.ssenderId = ssenderId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.initialBalance = initialBalance;
		this.finalBalance = finalBalance;
		this.transactionperformedby = transactionperformedby;
	}

	

	public String getTransactionperformedby() {
		return transactionperformedby;
	}



	public void setTransactionperformedby(String transactionperformedby) {
		this.transactionperformedby = transactionperformedby;
	}



	public LocalDateTime getTimestamp() {
		return Timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		Timestamp = timestamp;
	}


	public String getSsenderId() {
		return ssenderId;
	}


	public void setSsenderId(String ssenderId) {
		this.ssenderId = ssenderId;
	}


	public Double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public Double getInitialBalance() {
		return initialBalance;
	}


	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}


	public Double getFinalBalance() {
		return finalBalance;
	}


	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
	}



	@Override
	public String toString() {
		return "Transaction [Timestamp=" + Timestamp + ", ssenderId=" + ssenderId + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + ", initialBalance=" + initialBalance
				+ ", finalBalance=" + finalBalance + ", transactionperformedby=" + transactionperformedby + "]";
	}
	
	
}
