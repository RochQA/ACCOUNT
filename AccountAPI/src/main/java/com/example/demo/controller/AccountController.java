package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.entities.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	

	public AccountService svc;	
	public RestTemplate rest;

	public AccountController(AccountService svc, RestTemplate rest) {
		this.svc = svc;
		this.rest = rest;
	}

	@PostMapping("/createAccount")
	public Account createAccount(Account account) {
		account.setAccountNumber(genAccountNumber());
		account.setPrize(genPrize(account.getAccountNumber()));
		return svc.createAccount(account);
		
	}
	
	@GetMapping("/getAccounts")
	public List<Account> getAccounts() {
		return svc.getAccounts();	
	}
	
	public String genAccountNumber() {	
		String url = "http://localhost:8081/genAccNum";
		ResponseEntity<String> response = rest.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
	public String genPrize(String accNum) {		
		String url = "http://localhost:8082/genPrize";
		HttpEntity<String> request = new HttpEntity<>(accNum);
		ResponseEntity<String> response = rest.exchange(url, HttpMethod.POST, request, String.class);
		return response.getBody();
	}
}
