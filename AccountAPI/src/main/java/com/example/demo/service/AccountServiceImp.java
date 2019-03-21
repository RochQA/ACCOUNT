package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Login;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	

	AccountRepository repo;
	Account account;

	public AccountServiceImp(AccountRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Account getAccount(Long id) {
		List<Account> allAccounts = getAllAccounts();
		account = null; 
		allAccounts.stream().forEach(a ->{ if(a.getId().equals(id)) {account=a;}});
//		for(int i=0;i<allAccounts.size();i++) { 
//			if(allAccounts.get(i).getId()==id) { 
//				account=allAccounts.get(i);
//			}
//		}
		return account;
	}
	@Override
	public Account createAccount(Account accountIn) {
		return repo.save(accountIn);
		
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
	public Account updateAccount(Account accountIn) {
		Long id = accountIn.getId();
		Account upAccount = getAccount(id);
		if(upAccount != null) {
			upAccount.setAccountName(accountIn.getAccountName());
			upAccount.setAccountNumber(accountIn.getAccountNumber());
			upAccount.setPrize(accountIn.getPrize());
			repo.save(upAccount);
		}
		
		return upAccount;
	}
	@Override
	public Account login(Login login) {
		account = null;
		String name = login.getName();
		String password = login.getPassword();
		List<Account> allAccounts = getAllAccounts();
		allAccounts.stream().forEach(a ->{ if(a.getAccountName().equals(name)){if(a.getPassword().equals(password)) {account=a;}}});
//		for(int i=0;i<allAccounts.size();i++) { 
//			if(allAccounts.get(i).getAccountName().equals(login.getName())) {
//				if(allAccounts.get(i).getPassword().equals(login.getPassword())) {
//					account=allAccounts.get(i);			
//				}
//			}		
//		}
		if(account!=null) {
			return account;
		}else return getAccount(0L);
	}
}
