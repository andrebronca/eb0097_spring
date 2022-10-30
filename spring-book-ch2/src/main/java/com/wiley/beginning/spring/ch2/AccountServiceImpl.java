package com.wiley.beginning.spring.ch2;

public class AccountServiceImpl implements AccountService {
	private AccountDao dao;

	public void setAccountDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
		Account sourceAccount = dao.find(sourceAccountId);
		Account targetAccount = dao.find(targetAccountId);
//		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		sourceAccount.retirar(amount);
//		targetAccount.setBalance(targetAccount.getBalance() + amount);
		targetAccount.receber(amount);
		dao.update(sourceAccount);
		dao.update(targetAccount);
	}

	@Override
	public void depositMoney(long accountId, double amount) throws Exception {
		Account account = dao.find(accountId);
		account.receber(amount);
		dao.update(account);
	}

	@Override
	public Account getAccount(long accountId) {
		return dao.find(accountId);
	}

}
