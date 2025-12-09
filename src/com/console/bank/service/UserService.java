package com.console.bank.service;

import com.console.bank.entity.User;
import com.console.bank.repository.Repository;

public class UserService {
	
	private Repository userRepository = new Repository();
	
	public void printUsers() {
		
		userRepository.printUsers();
	}
	
	public User login(String username , String password) {
		 return userRepository.login(username, password);
	}
	
	public boolean addnewCustomer(String username , String password,String contact) {
		return userRepository.addnewCustomer(username,password,contact);
	}
	
	public Double checkBankBalance(String userId) {
		return userRepository.checkBankBalance(userId);
	}
	
	public User getUser(String userId) {
		return userRepository.getUser(userId);
	}
	
	public boolean transferAmount(String userId , String payUserId , Double amount) {
		return userRepository.transferAmount(userId, payUserId, amount);
	}
	public void printTransaction(String UserId){
		userRepository.printTransaction(UserId);
	}
}
