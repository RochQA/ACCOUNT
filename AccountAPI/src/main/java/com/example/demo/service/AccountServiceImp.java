package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Login;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	

	AccountRepository repo;

	public AccountServiceImp(AccountRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Account getAccount(Long id) {
		List<Account> allAccounts = getAllAccounts();
		Account account = new Account(); 
		for(int i=0;i<allAccounts.size();i++) { 
			if(allAccounts.get(i).getId()==id) { 
				account=allAccounts.get(i);
			}
		}
		return account;
	}
	@Override
	public Account createAccount(Account account) {
		return repo.save(account);
		
	}
	@Override
	public List<Account> getAllAccounts(){
		return repo.findAll();
	}
	@Override
	public String deleteAccount(Long id) {
		repo.deleteById(id);
		return "Account deleted";
	}
	@Override
	public Account updateAccount(Account account) {
		Long id = account.getId();
		Account upAccount = getAccount(id);
		if(upAccount != null) {
			upAccount.setAccountName(account.getAccountName());
			upAccount.setAccountNumber(account.getAccountNumber());
			upAccount.setPrize(account.getPrize());
			repo.save(upAccount);
		}
		
		return upAccount;
	}
	@Override
	public Account login(Login login) {
		Account account = null;
		List<Account> allAccounts = getAllAccounts();
		for(int i=0;i<allAccounts.size();i++) { 
			if(allAccounts.get(i).getAccountName().equals(login.getName())) {
				if(allAccounts.get(i).getPassword().equals(login.getPassword())) {
					account=allAccounts.get(i);			
				}
			}		
		}
		if(account!=null) {
			return account;
		}else return getAccount(0L);
	}
}
