package com.example.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.entities.AccountNumber;
import com.example.demo.repository.AccountNumberRepository;

@Service
public class AccountNumGenService implements AccountNumGen {
	
	AccountNumberRepository repo;
	
	
	
	public AccountNumGenService(AccountNumberRepository repo) {
		this.repo = repo;
	}
	private Boolean unique;
	private Boolean created;
	String generatedAccNum;
	
	 
	@Override
	public String accountNum() {
		created = false;
		Random ran = new Random();
		int len=0;
		int length = ran.nextInt(3);
		if(length==0) {
			len=6;
		}else if(length==1) {
			len=8;
		}else if(length==2) {
			len=10;
		}
		while(!created) {
			genAccountNum(len);
		}
		return generatedAccNum;
	}

	@Override
	public String genAccountNum(int length) {


		generatedAccNum = "";
		Random ran = new Random();
		int letter = ran.nextInt(3);
		

		if (letter == 0) {
			generatedAccNum += "a";
		} else if (letter == 1) {
			generatedAccNum += "b";
		} else if (letter == 2) {
			generatedAccNum += "c";
		}
		for (int i = 0; i < length; i++) {
			generatedAccNum += ran.nextInt(10);
		}
		if(checkAccountNum(generatedAccNum)) {
			AccountNumber account = new AccountNumber();
			account.setAccountNumber(generatedAccNum);
			created=true;
			
		}
		return generatedAccNum;
	}
	
	@Override
	public Boolean checkAccountNum(String accNum) {
		List<AccountNumber> accounts = repo.findAll();
		unique = true;
		for(int i=0; i<accounts.size();i++) {
			if(accounts.get(i).getAccountNumber().equals(accNum)) {
				unique = false; 
			}
		}
		return unique;
		
	}
	}


