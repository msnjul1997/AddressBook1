package com.bridgelabz;

import java.util.Scanner;

public class AddressBook {
	
	 public static void addContact()
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Please enter your first name :");
	        
	        String first_name = sc.next();
	        System.out.println("Please enter your last name :");
	        
	        String last_name = sc.next();
	        sc.nextLine();
	        System.out.println("Please enter your address :");
	        
	        String address = sc.nextLine();
	        System.out.println("Please enter your city :");
	        
	        String city = sc.next();
	        System.out.println("Please enter your state :");
	        
	        String state = sc.next();
	        System.out.println("Please enter your zip code :");
	        
	        int zip = sc.nextInt();
	        System.out.println("Please enter your phone number :");
	        
	        long phone = sc.nextLong();
	        System.out.println("Please enter your email id :");
	        
	        String email_id = sc.next();
	        Contact c = new Contact(first_name, last_name, address, city, state, zip, phone, email_id);
	    }
	    public static void main(String[] args) {

	        System.out.println("---Welcome to Address Book---");
	        System.out.println();
	        AddressBook.addContact();
	    }
}
