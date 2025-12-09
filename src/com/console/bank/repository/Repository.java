package com.console.bank.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.console.bank.entity.Transaction;
import com.console.bank.entity.User;

public class Repository {
	
	private static Set<User> users = new HashSet<>();
	private static List<Transaction> transactions = new ArrayList<Transaction>();

	static {
		
		User user1 = new User( "admin" , "admin", "012345678" ,"admin" , 500.0);
		User user2 = new User( "user2" , "user2", "123456789" ,"user" ,  1000.0);
		User user3 = new User( "user3" , "user3", "12345678" ,"user" ,  1500.0);
		User user4 = new User( "kunal" , "k2001", "882822001" ,"user" ,  15000.0);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}
	

	public void printUsers() {
		System.out.println(users);
	}
	
	public User login(String username , String password) {
		List<User> finalList= users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(username)&& user.getPassword().equals(password))
				.collect(Collectors.toList());
		
		if(!finalList.isEmpty()) {
			return finalList.get(0);
		}else {
			return null;
		}
	}
	
	public boolean addnewCustomer(String username , String password,String contact) {
		User user = new User(username,password,contact, "user", 500.0);
		return users.add(user);
	}
	
	public Double checkBankBalance(String userId) {
		List<User> result = users.stream().filter(user -> user.getUsername().equals(userId)).collect(Collectors.toList());
		
		if(!result.isEmpty()) {
			return result.get(0).getAccountbalance();
		}else {
			return null;
		}
	}
	
	public User getUser(String userId) {
		List<User> result = users.stream().filter(user -> user.getUsername().equals(userId)).collect(Collectors.toList());
		if(! result.isEmpty()) {
			return result.get(0);
		}
			return null;
	}
	public boolean transferAmount(String userId , String payUserId , Double amount) {
		
		boolean inDebit = debit(userId,amount,payUserId);
		boolean inCredit = credit(payUserId, amount,userId);
		
		return inCredit && inDebit;
		
	}
	
	private boolean debit(String userId , Double amount, String payUserId) {
		User user = getUser(userId);
		
		Double accountBalance = user.getAccountbalance();
		
		users.remove(user);
		
		Double finalBalance = accountBalance - amount ;
		user.setAccountbalance(finalBalance);
		
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			payUserId,
			amount,
			"debit",
			accountBalance,
			finalBalance,
			userId
		);
		System.out.println(transaction);
		transactions.add(transaction);
		return users.add(user);
		}
	
	private boolean credit(String payUserId , Double amount , String userId) {
		User user = getUser(payUserId);
		
		Double accountBalance = user.getAccountbalance();
		users.remove(user);
		Double finalBalance = accountBalance + amount ;
		user.setAccountbalance(finalBalance);
		
		Transaction transaction = new Transaction(
				LocalDateTime.now(),
				userId,
				amount,
				"credit",
				accountBalance,
				finalBalance,
				payUserId
				
			);
		System.out.println(transaction);
		transactions.add(transaction);
		return  users.add(user);
		}
	
	public void printTransaction(String UserId){
		List<Transaction> filteredTransaction = transactions.stream().filter(transaction -> transaction.getTransactionperformedby().equals(UserId)).collect(Collectors.toList());
		
		System.out.println("Date \t User Id \t Amount \t Type \t Intial Balance \t Final balance");	
		System.out.println("--------------------------------------------------------------------");
		for(Transaction t : filteredTransaction) {
				System.out.println(t.getTimestamp()
						+"\t"+ t.getSsenderId()
						+"\t"+ t.getTransactionAmount()
						+"\t"+ t.getTransactionType()
						+"\t"+ t.getInitialBalance()
						+"\t"+ t.getFinalBalance());
			}
	}
}
