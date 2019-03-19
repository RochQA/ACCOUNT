package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.service.AccountNumGen6;

@RestController
@EnableWebMvc
public class AccountNumGenController {
	

	public AccountNumGen6 svc;	

	public AccountNumGenController(AccountNumGen6 svc) {
		this.svc = svc;
	}

	@GetMapping("/genAccNum")
	public String createAccountNumber() {
		return svc.genAccountNum();	
	}
}
