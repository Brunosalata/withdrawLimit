package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.Exceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data/n");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.print("\nEnter amount for deposit: ");
		double dAmount = sc.nextDouble();
		acc.deposit(dAmount);
		
		System.out.printf("New Balance: %.2f%n", acc.getBalance());
		
		System.out.print("\nEnter amount for withdraw: ");
		double wAmount = sc.nextDouble();
		
		try {
			acc.withdraw(wAmount);
			System.out.printf("New Balance: %.2f%n", acc.getBalance());
		} catch (Exceptions e){
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
