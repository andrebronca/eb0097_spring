package com.wiley.beginning.spring.ch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoInMemoryImpl implements AccountDao {

	private Map<Long, Account> accountsMap = new HashMap<>();
	{
		Account a1 = new Account();
		a1.setId(1L);
		a1.setOwnerName("John");
		a1.setBalance(10.0);

		Account a2 = new Account();
		a2.setId(2L);
		a2.setOwnerName("Mary");
		a2.setBalance(20.0);

		accountsMap.put(a1.getId(), a1);
		accountsMap.put(a2.getId(), a2);
	}

	@Override
	public void update(Account account) {
		accountsMap.put(account.getId(), account);
	}

	//livro não implementa
	@Override
	public void insert(Account account) {
		accountsMap.put(account.getId(), account);
	}

	//livro não implementa
	@Override
	public void update(List<Account> accounts) {
		for(Account a : accounts) {
			accountsMap.put(a.getId(), a);
		}
	}

	//livro não implementa
	@Override
	public void delete(long accountId) {
		accountsMap.remove(accountId);
	}

	@Override
	public Account find(long accountId) {
		return accountsMap.get(accountId);
	}

	//livro não implementa
	@Override
	public List<Account> find(List<Long> accountIds) {
		List<Account> accounts = new ArrayList<Account>();
		for(long id : accountIds) {
			Account a = find(id);
			if (a != null) {
				accounts.add(a);
			}
		}
		return accounts;
	}

	//livro não implementa
	@Override
	public List<Account> find(String ownerName) {
		List<Account> accounts = new ArrayList<Account>();
		for(Account a : accountsMap.values()) {
			if (a.getOwnerName().equalsIgnoreCase(ownerName)) {
				accounts.add(a);
			}
		}
		return accounts;
	}

	@Override
	public List<Account> find(boolean locked) {
		//não foi especificado a regra do que é locked
		return null;
	}

}
