package com.pradeep.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pradeep.banking.dao.AccountRepository;
import com.pradeep.banking.model.Account;


@Transactional
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	public AccountServiceImpl() {
		System.out.println("AccountService default constructor created.....");
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return repository.save(account) == account;
	}

	@Override
	public boolean deleteAccount(int accno) {

		Account account = repository.findById(accno).get();

		if (account != null) {
			repository.delete(account);
			return true;
		}

		return false;
	}

	@Override
	public boolean updateAccount(Account account) {

		Account account1 = repository.findById(account.getAccno()).get();

		if (account1 != null) {
			repository.save(account);
			return true;
		}

		return false;
	}

	@Transactional(readOnly=true)
	
	@Override
	public Account getAccount(int accno) {
		// TODO Auto-generated method stub
		return repository.findById(accno).get();

	}


	@Transactional(readOnly=true,timeout=1)
	@Override
	public List<Account> getAllAccounts() {
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public boolean withdraw(int accno, double amount) {
		Account account1 = repository.findById(accno).get();

		if (account1 != null) {
			account1.setBalance(account1.getBalance() - amount);
			repository.save(account1);
			return true;
		}

		return false;
	}

	@Override
	public boolean deposit(int accno, double amount) {
		Account account1 = repository.findById(accno).get();

		if (account1 != null) {
			account1.setBalance(account1.getBalance() + amount);
			repository.save(account1);
			return true;
		}

		return false;
	}

	
	@Transactional(noRollbackForClassName={"java.lang.ArithmeticException"})
	@Override
	public boolean fundTransfer(int source, int destination, double amount) {
		
		withdraw(source, amount);
		
		int a=100/0;
		
		deposit(destination, amount);
			
		return false;
	}

}
