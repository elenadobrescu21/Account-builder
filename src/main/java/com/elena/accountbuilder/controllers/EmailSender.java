package com.elena.accountbuilder.controllers;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.elena.accountbuilder.models.User;

public class EmailSender {
	
	private final static String USERNAME = "elena.alexandra.dobrescu";
	private final static String PASSWORD = "apaplata1";
	
	public EmailSender() {
		
	}
	
	public Properties setProperties() {
		 Properties props = new Properties();
	     props.put("mail.smtp.host", "smtp.gmail.com");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.port", "465");
	     return props;
	}
	
	public void sendEmail(User user) {
		 String to = user.getEmail();	          
	     Session session = Session.getDefaultInstance(setProperties(),
	        new javax.mail.Authenticator() {
	     protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication("elena.alexandra.dobrescu", "apaplata1");
	        //change according to your information
	     }
	      });
	      
	      try {
	       MimeMessage message = new MimeMessage(session);
	       message.setFrom(new InternetAddress("elena.alexandra.dobrescu@gmail.com"));
	       //change accordingly
	       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	       message.setSubject("Login credentials");
	       message.setText("Your username is " + user.getAccount().getUsername()  + " and your password is" + user.getAccount().getPassword());	          
	          //send message
	       Transport.send(message);
	       System.out.println("message sent successfully");
	      }
	      catch (MessagingException e) {throw new RuntimeException(e);}
		}
	}
	


