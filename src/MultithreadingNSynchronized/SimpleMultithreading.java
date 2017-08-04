package MultithreadingNSynchronized;

import java.util.Scanner;
/**
 * 
 * @author Vishwas
 * In this program i'm creating a Online Banking Application application 
 * which will show how  Multithreading are work but as mention in question
 * to show the difference output without using synchronized i'm not using 
 * synchronized keyword
 */

class Account {
	/**
	 * declaring a variable  bal;
	 * than creating a constructor and passing 'bal' to set the balance 
	 * and assigning the balance
	 */
	private int bal;
	public Account(int bal){
		this.bal=bal;
		
	}
	/**
	 * 
	 * In here creating a method  which is isSufficientBalance 
	 * to check balance is Sufficient or not, so that in constructor i'm 
	 * passing 'w' and also applying if statement to the check condition if 
	 * balance is greater than return true and withdraw money, else return false;
	 *  
	 * 
	 */
	public boolean isSufficientBalance(int wdrw){
		if(bal>wdrw)
			return(true);
		else
			return(false);
	}
	    /**
	     * In here creating a another method  which is withdraw 
	     * this method will update our Amount; 
	     * than concatenating 'amt' with window console 
		 * to print the withdraw money'
		 * and again concatenating 'bal' with window console 
		 * to print the current balance of account
		 */
	public void withdraw(int amt){
		bal=bal-amt;
		
		System.out.println("Withdraw money is : " +amt);
		System.out.println("Your current balance is : " +bal);
	}
}

/**
 * crating a class Customer and declaring variable
 * than created a constructor and passing Account class reference 
 * 
 */
class Customer implements Runnable {
	
	private Account account;
	private String name;
	public Customer(Account account,String n){
		/**
		 * this is instants variable account which is 
		 * assign in local variable account and also assigned name
		 */
		this.account=account;
		name=n;
	}
	public void run(){
		/**
		 * in here taking user input to enter the amount
		 * and whatever amount will enter user, that will 
		 * store in amt variable.
		 */
		Scanner scan= new Scanner(System.in);
		System.out.println(name + ",Enter amount to withdraw");
		int amt=scan.nextInt();
		
		if(account.isSufficientBalance(amt))
		{
			System.out.println(name);
		account.withdraw(amt);	
		}else
			System.out.println("Insufficient Balance");
			
	}
}
/**
 * created class SimpleMultithreading and main method 
 * than creating objects of classes first is Account class object and 
 * than two customer classes objects and in Account object i've pass 
 * 1000 as available balance and both of the customer objects 
 * passing same account and both the customer have different name 
 * but both are accessing same resources(Account) 
 * after that creating threads 
 * then calling threads with start method
 * 
 */

public class SimpleMultithreading {
	//main methods
	public static void main(String[]agrs){
		System.out.println("without synchronized\n");
		
		Account  account1 =new Account(1000);
		Customer ctomerus1=new Customer(account1,"sushant");
		Customer ctomerus2=new Customer(account1,"vishwas");
		
		Thread thread1=new Thread(ctomerus1);
		Thread thread2=new Thread(ctomerus2);
	
		thread1.start();
		thread2.start();
		
		
	}
	
}