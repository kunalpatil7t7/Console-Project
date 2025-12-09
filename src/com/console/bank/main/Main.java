	package com.console.bank.main;
	
	import java.util.Scanner;
	
	import com.console.bank.entity.User;
	import com.console.bank.service.UserService;
	
	public class Main {
	
		private static Scanner scanner = new Scanner(System.in); 
		
		static Main main = new Main();
		static UserService userService = new UserService();
		
		public static void main(String[] args) {
				
			while(true) {
				System.out.println("Enter your Username");
				String Username = scanner.next();
				
				System.out.println("Enter your Password");
				String Password = scanner.next();
				
	//			System.out.println("Username : " + Username + " Password :" + Password );
				
				User user = userService.login(Username, Password);
				if(user != null && user.getRole().equals("admin")) {
					main.Admin();
				}else if(user != null && user.getRole().equals("user")) {
					main.Customer(user);
				}else {
					System.out.println("Login failed");
				}	
			}		
		}
		
			private void Admin() {
				
				boolean flag  = true;
				while(flag) {
					System.out.println("Select an option ");
					System.out.println("1. Create a new account ");
					System.out.println("2. View Transactions");
					System.out.println("3. Check Balance");
					System.out.println("4. Logout");
					
					int option = scanner.nextInt();
					
					switch (option) {
					case 1: 
						main.addnewCustomer();
						break;
					case 2:
						System.out.println("Enter user ID");
						String userID = scanner.next();
						printTransaction(userID);
						break;
					case 3:
						System.out.println("enter user ID");
						String Userid = scanner.next();
						Double  accountbalance = checkBankBalance(Userid);
						System.out.println("Your account balance is : " + accountbalance);
						break;
					case 4: 
						flag = false;
						System.out.println("You are successfully logout..");
						break;
					default:
						System.out.println("Invalid");
					}
				}
				
	
			}
			
			private void addnewCustomer() {
				System.out.println("Enter username");
				String username = scanner.next();
				
				System.out.println("Enter username");
				String password = scanner.next();
				
				System.out.println("Enter username");
				String contact = scanner.next();
				
				boolean result =userService.addnewCustomer(username, password, contact);
				
				if(result == true) {
					System.out.println("New customer is created");
				}else {
					System.out.println("Account creation failed");
				}
		}
			
			private void Customer(User user) {
				boolean flag  = true;
				while(flag) {
					System.out.println("\nSelect an option ");
					System.out.println("1. Check Balance ");
					System.out.println("2. Fund Transfer");
					System.out.println("3. Transaction History");
					System.out.println("4. Logout");
					
					int option = scanner.nextInt();
					switch (option) {
					case 1: 
						Double balance = main.checkBankBalance(user.getUsername());
						if(balance != null) {
							System.out.println("Your bank balance is :" + balance);
						}else {
							System.out.println("Check your Username");
						}
						break;
						
					case 2:
						main.fundTransfer(user);
						break;
					case 3: 
						main.printTransaction(user.getUsername());
						break;
					case 4: 
						flag = false;
						System.out.println("You are successfully logout..");
						break;
					
					default:
						System.out.println("Invalid");
					}
			}
		}
			
			private void fundTransfer(User userDetail) {
				System.out.println("Enter pay account user id");
				String Payaccount = scanner.next();
				
				User user = getUser(Payaccount);
				if(user != null) {
					System.out.println("Enter amount to Transfer");
					Double amount = scanner.nextDouble();
					
					Double userAccountBalance = checkBankBalance(userDetail.getUsername());
					
					if(userAccountBalance >= amount) {
						boolean result = userService.transferAmount(userDetail.getUsername(), Payaccount, amount);
						
						if(result) {
							System.out.println("Transfer Successfull..!");
						}else {
							System.out.println("Transfer failed");
						}
					}else {
						System.out.println("Your balance is insufficient :" + userAccountBalance);
					}
				}else {
					System.out.println("Enter valid Username");
				}
				
			}
			
			private User getUser(String userId) {
				return userService.getUser(userId);
			}
			
			private Double checkBankBalance(String userId) {
				return userService.checkBankBalance(userId);
			}
			private void printTransaction(String UserId){
				userService.printTransaction(UserId);
			}
	}
