package com.bridgelabz;

import java.util.Scanner;

public class AddressBook {

		 public static void main(String[] args) {

		        System.out.println("---Welcome to Address Book---");
		        System.out.println();
		        AddressBookService.addContact();
		        AddressBookService.display();
		        AddressBookService.editContact();
		    }
}
