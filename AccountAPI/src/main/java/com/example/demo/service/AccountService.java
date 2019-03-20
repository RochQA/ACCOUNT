package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public List<Account> getAllAccounts();

	public String deleteAccount(Long id);

	Account updateAccount(Account account);

	Account getAccount(Long id);
	
	String checkAccountNumber(String string);

}
