package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountNumberGenerator;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	

	AccountRepository repo;
	AccountNumberGenerator numGen;

	public AccountService(AccountRepository repo, AccountNumberGenerator numGen) {
		this.repo = repo;
		this.numGen = numGen;
	}
	public Account createAccount(Account account) {
		return repo.save(account);
		
	}
	public List<Account> getAccounts(){
		return repo.findAll();
	}

}
