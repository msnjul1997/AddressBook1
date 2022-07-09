package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
@FunctionalInterface
interface ICheckDuplicate{
    boolean checkDuplicate(String f_name,String l_name);
}

public class AddressBookService {
	public static Scanner sc = new Scanner(System.in);
	  public static ArrayList<Contacts> arrayOfContacts;
	  
	    public static HashMap<String, ArrayList<Contacts>> hashMapOfAddressBooks = new HashMap<>();

	    public static HashMap<String,String> dictionaryForState = new HashMap<String,String>();
	    public static HashMap<String,String> dictionaryForCity = new HashMap<String,String>();
	    public static ArrayList<Contacts> findAddressBook(String name) {
	        for (Map.Entry<String, ArrayList<Contacts>> iterator : hashMapOfAddressBooks.entrySet()) {
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
	        if(AddressBookService.checkDuplicate(bookName,first_name,last_name)) {
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
	            dictionaryForState.put(first_name+" "+last_name,state);
	            dictionaryForCity.put(first_name+" "+last_name,city);
	            if (findAddressBook(bookName) != null) {
	                hashMapOfAddressBooks.get(bookName).add(c);
	                try {
	                    AddressBookIo.writeIntoFile();
	                }
	                catch (IOException e)
	                {
	                    System.out.println(e.getMessage());
	                }
	                return;
	            }
	            arrayOfContacts = new ArrayList<Contacts>();
	            arrayOfContacts.add(c);
	            hashMapOfAddressBooks.put(bookName, arrayOfContacts);
	        }
	        else{
	            System.out.println("The contact with name: "+first_name+" already exists.\n"+hashMapOfAddressBooks.get(bookName));
	        }
	        try {
	            AddressBookIo.writeIntoFile();
	        }
	        catch (IOException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    public static void displayByOrder() {
	        System.out.println(" Please enter the name of the address book: ");
	        String name = sc.next();
	        if(hashMapOfAddressBooks.get(name).isEmpty())
	        {
	            System.out.println("The Address Book is empty.");
	            return;
	        }
	        hashMapOfAddressBooks.get(name).stream().sorted((contact1, contact2) -> contact1.getFirstName().compareToIgnoreCase(contact2.getFirstName()))
	                .forEach(contact -> System.out.println(contact));
	        try {
	            System.out.println("Data inserted in file is:");
	            AddressBookIo.readFromFile();
	        }
	        catch (IOException e){
	            System.out.println(e.getMessage());
	        }
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
	    //Overriding the equals() method.
	    public static boolean checkDuplicate(String book,String name,String last_name) {
	        if(hashMapOfAddressBooks.get(book) == null) {
	            return true;
	        }
	        ArrayList<Contacts> arrayList = hashMapOfAddressBooks.get(book);
	        HashMap<String,String> names = new HashMap<String,String>();
	        for (Contacts c: arrayList) {
	            names.put(c.getFirstName(),c.getLastName());
	        }
	        ICheckDuplicate checkDuplicate = ((f_name, l_name) -> {
	            if(f_name.equals(name) && l_name.equals(last_name)){
	                return false;
	            }
	            return true;
	        });
	        Boolean ansToDuplicates = names.entrySet().stream()
	                .anyMatch(n->checkDuplicate.checkDuplicate(n.getKey(),n.getValue()));
	        return ansToDuplicates;
	    }
	    public static void findSameStateContacts(String state)
	    {
	        dictionaryForState.entrySet().stream()
	                .filter(n->n.getValue().equals(state))
	                .forEach(n-> System.out.println(n));
	        long countState = dictionaryForCity.entrySet().stream()
	                .map(n->n.getValue().equals(state))
	                .count();
	        System.out.println("Total number of people with state "+state+" are:"+countState);
	    }
	    public static void findSameCityContacts(String city)
	    {
	        dictionaryForCity.entrySet().stream()
	                .filter(n->n.getValue().equals(city))
	                .forEach(n-> System.out.println(n));
	        long countState = dictionaryForCity.entrySet().stream()
	                .map(n->n.getValue().equals(city))
	                .count();
	        System.out.println("Total number of people with state "+city+" are:"+countState);
	    }
	    public static void sortByCity()
	    {
	        System.out.println("Sorted by city names:");
	        hashMapOfAddressBooks.values().forEach((n)->{
	            n.stream().sorted((contact1,contact2) -> {
	              return contact1.getCity().compareToIgnoreCase(contact2.getCity());
	            }).forEach(n1-> System.out.println(n1));
	        });
	    }
	    public static void sortByState()
	    {
	        System.out.println("Sorted by state names:");
	        hashMapOfAddressBooks.values().forEach((n)->{
	            n.stream().sorted((contact1,contact2) -> {
	                return contact1.getState().compareToIgnoreCase(contact2.getState());
	            }).forEach(n1-> System.out.println(n1));
	        });
	    }
	    public static void sortByZip()
	    {
	        System.out.println("Sorted by city names:");
	        hashMapOfAddressBooks.values().forEach((n)->{
	            n.stream().sorted((contact1,contact2) -> {
	                return contact1.getZip()==(contact2.getZip())?0:1;
	            }).forEach(n1-> System.out.println(n1));
	        });
	    }
}
