package com.bridgelabz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;

public class AddressBookIo {
	 static Gson gson = new Gson();
	    static File file = new File("AddressBook.csv");
	    public static  void writeIntoFile() throws IOException{
	        FileWriter fileWriter = new FileWriter(file);
	        CSVWriter csvWriter = new CSVWriter(fileWriter);
	        String[] strContacts = new String[40];
	        List<String[]> contacts = new ArrayList<>();
	        AddressBookService.hashMapOfAddressBooks.entrySet().stream().forEach(n->
	                {
//	                    try {
//	                        fileWriter.write(n.getKey()+n.getValue());
//	                    } catch (IOException e) {
//	                        throw new RuntimeException(e);
//	                    }
	                        strContacts[0] = n.getKey();
	                        strContacts[1] = n.getValue().toString();
	                    contacts.add(strContacts);
	                    csvWriter.writeAll(contacts);
	                }
	        );
	        fileWriter.close();
	        System.out.println("--Data Inserted--");
	    }
	    public static void readFromFile() throws IOException {
	        Scanner sc = new Scanner(file);
	        sc.useDelimiter(",");
	        while (sc.hasNext())
	        {
	            System.out.print(sc.next());
	        }
	        sc.close();
	    }

}
