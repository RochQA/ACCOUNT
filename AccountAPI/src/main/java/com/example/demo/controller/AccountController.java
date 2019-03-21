package com.example.demo.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Account;
import com.example.demo.entities.Login;
import com.example.demo.service.AccountServiceImp;

@RestController
@CrossOrigin
public class AccountController {
	
	public AccountServiceImp svc;	
	
	public RestTemplate rest;

	public AccountController(AccountServiceImp svc, RestTemplateBuilder rest) {
		this.svc = svc;
		this.rest = rest.build();
	}

	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		account.setAccountNumber(genAccountNumber());
		account.setPrize(genPrize(account.getAccountNumber()));
		return svc.createAccount(account);	
	}	
	@GetMapping("/getAccounts")
	public List<Account> getAccounts() {
		return svc.getAllAccounts();	
	}
	@GetMapping("/getAccount/{id}")
	public Account getAccount(@PathVariable Long id) {
		return svc.getAccount(id);
	}
	@DeleteMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable Long id) {
		return svc.deleteAccount(id);
	}
	@PutMapping("/login")
	public Account login(@RequestBody Login login) {
		return svc.login(login);
	}
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestBody Account account) {
		return svc.updateAccount(account);
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
