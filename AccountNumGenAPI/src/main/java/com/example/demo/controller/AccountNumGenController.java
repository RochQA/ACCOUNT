package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AccountNumGenService;

@RestController
public class AccountNumGenController {
	

	public AccountNumGenService svc;	

	public AccountNumGenController(AccountNumGenService svc) {
		this.svc = svc;
	}

	@GetMapping("/genAccNum")
	public String createAccountNumber() {
		return svc.accountNum();	
	}
}
