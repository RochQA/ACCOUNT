package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.service.AccountPrizeGenerator;

@RestController
@EnableWebMvc
public class AccountPrizeController {
	

	public AccountPrizeGenerator svc;	

	public AccountPrizeController(AccountPrizeGenerator svc) {
		this.svc = svc;
	}

	@PostMapping("/genPrize")
	public String getPrize(String accNum) {
		return svc.genPrize(accNum);	
	}
}
