package com.bridgelabz;

import java.util.Scanner;

public class AddressBook {
	 public static void main(String[] args) {

	        System.out.println("---Welcome to Address Book---");
	        Scanner sc = new Scanner(System.in);
	        System.out.println();
	        String option;
	        while(true) {
	            System.out.println(" ---- MENU ----");
	            System.out.println(" 1. Add contacts\n 2. Display contacts\n 3. Edit contacts\n 4. Delete contact\n 5. Exit");
	            option = sc.next();

	            switch (option) {
	                case "1":
	                    AddressBookService.addContact();
	                    break;
	                case "2":
	                    AddressBookService.display();
	                    break;
	                case "3":
	                    AddressBookService.editContact();
	                    break;
	                case "4":
	                    AddressBookService.deleteContact();
	                    break;
	                case "5":
	                    System.out.println("Thank You!");
	                    return;
	                default:
	                    System.out.println("Please enter a valid choice: ");
	            }

	        }


	    }
}
