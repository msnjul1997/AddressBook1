package com.bridgelabz;

import java.util.Scanner;

import com.bridgelabz.databaseconnection.AddressBookToDB;

public class AddressBook {
	  public static void main(String[] args) {

	        System.out.println("---Welcome to Address Book---");
	        Scanner sc = new Scanner(System.in);
	        System.out.println();
	        String option;
	        AddressBookToDB addressBookToDB = new AddressBookToDB();
	        while(true) {
	            System.out.println(" ---- MENU ----");
	            System.out.println(" 1. Add Address Book\n 2. Add contacts\n 3. Display contacts" +
	                    "\n 4. Edit contact\n 5. Delete Contact\n 6. Find Contacts with same state" +
	                    "\n 7. Find Contacts with same city \n 8.Sort the contacts by City State Or Zip.\n 9. Exit");
	            option = sc.next();

	            switch (option) {

	                case "1":
	                    AddressBookService.addAddressBook();
	                    break;
	                case "2":
	                    String addressBook;
	                    System.out.println("Enter the address book:");
	                    addressBook = sc.next();
	                    AddressBookService.addContact(addressBook);
	                    break;
	                case "3":
	                    AddressBookService.displayByOrder();
	                    break;
	                case "4":
	                    AddressBookService.editContact();
	                    break;
	                case "5":
	                    AddressBookService.deleteContact();
	                    break;
	                case "6":
	                    System.out.println("Enter the state: ");
	                    String state = sc.next();
	                    AddressBookService.findSameStateContacts(state);
	                    break;
	                case "7":
	                    System.out.println("Enter the city: ");
	                    String city = sc.next();
	                    AddressBookService.findSameCityContacts(city);
	                    break;
	                case "8":
	                    int option2;
	                    System.out.println("\t\nEnter 1: To sort by city:\nEnter 2: To sort by state:\nEnter 3: To sort by zip:");
	                    option2 = sc.nextInt();
	                    switch (option2){
	                        case 1 : AddressBookService.sortByCity();
	                            break;
	                        case 2 : AddressBookService.sortByCity();
	                            break;
	                        case 3:AddressBookService.sortByZip();
	                            break;
	                    }
	                    break;
	                case "9":
	                    System.out.println("Thank You!");
	                    return;
	                default:
	                    System.out.println("Please enter a valid choice: ");
	            }

	        }


	    }
	}
