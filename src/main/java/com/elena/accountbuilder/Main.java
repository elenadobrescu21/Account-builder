package com.elena.accountbuilder;

import com.elena.accountbuilder.controllers.AccountBuilder;
import com.elena.accountbuilder.controllers.EmailSender;
import com.elena.accountbuilder.models.Account;
import com.elena.accountbuilder.models.User;

public class Main {

	public static void main(String[] args) {
		User user = new User("Elena-Alexandra", "Dobrescu", "elena.dobrescu@cnmv.ro");
		AccountBuilder accBuilder = new AccountBuilder();
		String username = accBuilder.generateUserNameWithOneFirstname(user.getFirstName(), user.getLastName());
		String password = accBuilder.generateRandomPassword();
		Account account = new Account(username, password);
		user.setAccount(account);
		EmailSender emailSender = new EmailSender();
		emailSender.sendEmail(user);
			

	}

}
