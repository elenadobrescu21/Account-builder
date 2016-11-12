package com.elena.accountbuilder.controllers;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountBuilder {
	
	
	public AccountBuilder() {}
	
	public static boolean checkIfNameContainsWhiteSpace(String firstname) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(firstname);
		boolean found = matcher.find();
		return found;
	}
	
	public static boolean checkIfNameContainsLineDelimiter(String firstname) {
	
		boolean found = firstname.contains("-");
		return found;
	}
	
	public  boolean checkIfUserHasOnlyOneName(String firstname) {
		if(this.checkIfNameContainsWhiteSpace(firstname) || this. checkIfNameContainsLineDelimiter(firstname)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String generateUserNameWithOneFirstname(String firstname, String lastname) {
		boolean lineDelimiter = false;
		boolean spaceDelimiter = false;
		String usernameFirstname = new String();
		lineDelimiter = this.checkIfNameContainsLineDelimiter(firstname);
		spaceDelimiter = this.checkIfNameContainsWhiteSpace(firstname);
		if(lineDelimiter == true) {
			String[] splited = firstname.split("-");
			usernameFirstname = splited[0];
		}
		if(spaceDelimiter == true) {
			String[] splited = firstname.split("\\s");
			usernameFirstname = splited[0];
		}
		
		if(lineDelimiter==false && spaceDelimiter == false) {
			usernameFirstname = firstname;
		}
		
		return usernameFirstname + "_" + lastname;
				
	}
	
	public String generateRandomPassword() {
		String password = UUID.randomUUID().toString();
		return password;
		
	}

}
