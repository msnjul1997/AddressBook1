package com.bridgelabz;

public class Contact {
	 private String firstName;
	    private String lastName;
	    private String address;
	    private String city;
	    private String state;
	    private int zip;
	    private long phone;
	    private String email;

	    @Override
	    public String toString()
	    {
	        return "First name is: "+firstName+"\nLast Name is: "+lastName+"\nAddress is: "+address+"\nCity name is: "+city+
	                "\nState is: "+state+"\nZip is: "+zip+"\nPhone Number is: "+phone+"\nEmail Id is: "+email;
	    }

}
