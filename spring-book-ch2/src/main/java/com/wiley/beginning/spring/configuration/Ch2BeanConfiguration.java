package com.wiley.beginning.spring.configuration;

import com.wiley.beginning.spring.dao.AccountDao;
import com.wiley.beginning.spring.daoImpl.AccountDaoInMemoryImpl;
import com.wiley.beginning.spring.service.AccountService;
import com.wiley.beginning.spring.serviceImpl.AccountServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ch2BeanConfiguration {

	/**
	 * Esse método será chamado na Main
	 * @return
	 */
	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());
		return bean;
	}
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		return bean;
	}
}
