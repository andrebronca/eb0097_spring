package com.wiley.beginning.spring.ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.beginning.spring.configuration.Ch2BeanConfiguration;
import com.wiley.beginning.spring.service.AccountService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
	
		AccountService as = 
				appContext.getBean("accountService", AccountService.class);
	
		System.out.println("Before money transfer");
		System.out.println("Account 1 balance: "+ as.getAccount(1).getBalance());
		System.out.println("Account 2 balance: "+ as.getAccount(2).getBalance());
		
		as.transferMoney(1, 2, 5.25);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance: "+ as.getAccount(1).getBalance());
		System.out.println("Account 2 balance: "+ as.getAccount(2).getBalance());
		
		appContext.close();
		
	}
}
