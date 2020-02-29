package com.pradeep.banking.presentation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.banking.model.Account;
import com.pradeep.banking.service.AccountService;

@RequestMapping("/accounts")
@RestController
public class BankRestController {

	@Autowired
	private AccountService accountService;

	public BankRestController() {
		System.out.println("BankRestController default constructor....... ");
	}

	@PostMapping
	public List<Account> addAccount(@RequestBody Account account) {

		accountService.addAccount(account);
		return accountService.getAllAccounts();

	}



	@GetMapping
	public List<Account> getAllAccounts() {
	
		return accountService.getAllAccounts();

	}

	
	@PutMapping("/{accno}")
	public List<Account> updateAccount(@PathVariable("accno") int accno, Account account) {

		accountService.updateAccount(account);
		return accountService.getAllAccounts();

	}

	@DeleteMapping("/{accno}")
	public List<Account> deleteAccount(@PathVariable("accno") int accno) {

		accountService.deleteAccount(accno);
		return accountService.getAllAccounts();

	}

	@GetMapping("/{accno}")
	public Account showAccount(@PathVariable("accno") int accno) {
		return accountService.getAccount(accno);
	}



	@GetMapping("/withdraw/{source}/{amount}")
	public String withdraw(@PathVariable("source") int accno,@PathVariable double amount) {
	
		
		accountService.withdraw(accno, amount);
			
		return "Amount "+amount+"/- is debited from Account :"+accno;
	
	}

	@GetMapping("/deposit/{source}/{amount}")
	public String deposit(@PathVariable("source") int accno,@PathVariable double amount) {
	
		accountService.deposit(accno, amount);
		
		return "Amount "+amount+"/- is debited from Account :"+accno;
	
	}

	
	
	@GetMapping("/transfer/{source}/{destination}/{amount}")
	public String transfer(@PathVariable("source") int source,@PathVariable("destination") int destination,@PathVariable double amount) {
	
		accountService.fundTransfer(source, destination, amount);
		
		return "Amount "+amount+"/- is transferedfrom Account :"+source+"  to "+destination;
	
	}

		
	
	public void showAllAccounts() {
		System.out.println("All Account  Details\n===================");
		for (Account a : accountService.getAllAccounts())
			System.out.println(a);

	}

	@PostConstruct
	public void init() {
		System.out.println("BAnking App is going through initialization");

	}

	@PreDestroy
	public void destroy() {
		System.out.println("BAnking App is going through destruction");

	}

}
