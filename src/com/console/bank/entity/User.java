	package com.console.bank.entity;
	
	public class User {
	
		private String username;
		private String password;
		private String contact;
		private String role;
		private Double accountbalance;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Double getAccountbalance() {
			return accountbalance;
		}
		public void setAccountbalance(Double accountbalance) {
			this.accountbalance = accountbalance;
		}
		public User(String username, String password, String contact, String role, Double accountbalance) {
			super();
			this.username = username;
			this.password = password;
			this.contact = contact;
			this.role = role;
			this.accountbalance = accountbalance;
		}
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", contact=" + contact + ", role=" + role
					+ ", accountbalance=" + accountbalance + "]";
		}
		
		
	}
