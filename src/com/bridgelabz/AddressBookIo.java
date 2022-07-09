package com.bridgelabz;

import java.io.File;
import java.io.FileReader;
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
	        String str = gson.toJson(AddressBookService.hashMapOfAddressBooks);
	        file.createNewFile();
	        FileWriter fileWriter = new FileWriter(file);
	        fileWriter.write(str);
	        fileWriter.close();
	        System.out.println("Data inserted");
	    }
	    public static void readFromFile() throws IOException {
	        FileReader fileReader = new FileReader(file);
	        Object obj = gson.fromJson(fileReader,Object.class);
	        System.out.println(obj);
	        fileReader.close();
	    }
}
