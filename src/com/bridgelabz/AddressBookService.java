package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBookService {
	   public static Scanner sc = new Scanner(System.in);
	    public static ArrayList<Contacts> arrayOfContacts;
	    public static HashMap<String, ArrayList<Contacts>> hashMapOfAddressBooks = new HashMap<>();

	    public static ArrayList<Contacts> findAddressBook(String name) {
	        for (Entry<String, ArrayList<Contacts>> iterator : hashMapOfAddressBooks.entrySet()) {
	            if (iterator.getKey().equals(name)) {
	                return iterator.getValue();
	            }
	        }
	        return null;
	    }

	    public static String addAddressBook() {
	        System.out.println("Enter the Address Book");
	        String addressBookName = sc.next();
	        if (findAddressBook(addressBookName) != null) {
	            System.out.println("This Address Book already exists");
	            System.out.println(hashMapOfAddressBooks.get(addressBookName));
	            return null;
	        }
	        return addressBookName;
	    }
	    public static int findContact(ArrayList<Contacts> arrayList)
	    {
	        System.out.println("Enter the name: ");
	        String editName = sc.next();
	        for(Contacts c : arrayList)
	        {
	            if(editName.compareToIgnoreCase(c.getFirstName()) == 0)
	            {
	                return arrayList.indexOf(c);
	            }
	        }
	        return -1;
	    }
	    public static void addContact(String bookName) {
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
	        Contacts c = new Contacts(first_name, last_name, address, city, state, zip, phone, email_id);
	        if(findAddressBook(bookName) != null)
	        {
	            hashMapOfAddressBooks.get(bookName).add(c);
	            return;
	        }
	        arrayOfContacts =  new ArrayList<Contacts>();
	        arrayOfContacts.add(c);
	        hashMapOfAddressBooks.put(bookName,arrayOfContacts);

	    }

	    public static void display() {
	        System.out.println(" Please enter the name of the address book: ");
	        String name = sc.next();
	        if(hashMapOfAddressBooks.get(name).isEmpty())
	        {
	            System.out.println("The Address Book is empty.");
	            return;
	        }
	        System.out.println(hashMapOfAddressBooks.get(name));
	    }
	    public static void editContact() {
	        System.out.println("Enter the Address book you want to edit.");
	        String addressBookEdit = sc.next();
	        ArrayList<Contacts> arrayList = findAddressBook(addressBookEdit);
	        if(arrayList==null)
	        {
	            System.out.println("Address book not found");
	            return;
	        }
	        if (arrayList.isEmpty()) {
	            System.out.println("Address book with name " + addressBookEdit + " is empty");
	            return;
	        }
	       int index =  findContact(arrayList);
	        if(index == -1)
	        {
	            System.out.println("Details with this name is not found");
	            return;
	        }
	        System.out.println("Found the Contact");
	        arrayList.remove(index);
	        addContact(addressBookEdit);

	    }

	    public static void deleteContact() {
	        System.out.println("Enter the Address book you want to delete.");
	        String addressBookDel = sc.next();
	        ArrayList<Contacts> arrayList = findAddressBook(addressBookDel);
	        if(arrayList==null)
	        {
	            System.out.println("Address book not found");
	            return;
	        }
	        if (arrayList.isEmpty()) {
	            System.out.println("Address book with name " + addressBookDel + " is empty");
	            return;
	        }
	        int index =  findContact(arrayList);
	        if(index == -1)
	        {
	            System.out.println("Details with this name is not found");
	            return;
	        }
	        System.out.println("Deleted the Contact");
	        arrayList.remove(index);
	    }
}
