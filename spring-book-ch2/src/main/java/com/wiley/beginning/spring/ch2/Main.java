package com.wiley.beginning.spring.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		double amount = 5.30;
		String xml_file = "/com/wiley/beginning/spring/ch2/ch2-beans.xml";
//		AnnotationConfigApplicationContext appContext = 
//				new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
//		
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext(xml_file);
	
		AccountService as = 
				appContext.getBean("accountService", AccountService.class);
	
		System.out.println("Before money transfer");
		System.out.println("Account 1 balance: "+ as.getAccount(1).getBalance());
		System.out.println("Account 2 balance: "+ as.getAccount(2).getBalance());
		
		as.transferMoney(1, 2, amount);
		
		System.out.println("After money transfer: "+ amount);
		System.out.println("Account 1 balance: "+ as.getAccount(1).getBalance());
		System.out.println("Account 2 balance: "+ as.getAccount(2).getBalance());
		
		appContext.close();
		
	}
}
