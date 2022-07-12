package com.bridgelabz.databaseconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookToDB implements IAddressBookToDB{
	 Connection connection = (new DBConnection()).getConnection() ;
	    Statement statement;
	    ResultSet resultSet;
	    @Override
	    public void getData() {
	        String retrieveQuery = "select * from address_book;";
	        try {
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(retrieveQuery);
	            while(resultSet.next()){
	                System.out.println("Address Book Type: "+resultSet.getString("name"));
	                System.out.println("Address Book first_name: "+resultSet.getString("first_name"));
	                System.out.println("Address Book last_name: "+resultSet.getString("last_name"));
	                System.out.println("Address Book address: "+resultSet.getString("address"));
	                System.out.println("Address Book city: "+resultSet.getString("city"));
	                System.out.println("Address Book state: "+resultSet.getString("state"));
	                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
	                System.out.println("Address Book phone_number: "+resultSet.getLong("phone_number"));
	                System.out.println("Address Book email: "+resultSet.getString("email"));
	                System.out.println("----------------------");
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
