package com.wiley.beginning.spring.ch2.java_based_configuration;

import com.wiley.beginning.spring.configuration.Ch2BeanConfiguration;
import com.wiley.beginning.spring.service.AccountService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		double amount = 5.30;

		//contexto de carregamento bean por arquivo java
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(
		Ch2BeanConfiguration.class);
	
		//pesquisando o bean no contexto carregado
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
