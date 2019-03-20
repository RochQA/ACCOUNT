package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumGenService {
	
	AccountNumGen6 gen6;
	AccountNumGen8 gen8;
	AccountNumGen10 gen10;
	String response;
	
	AccountNumGenService(AccountNumGen6 gen6, AccountNumGen8 gen8,AccountNumGen10 gen10){
		this.gen6 = gen6;
		this.gen8 = gen8;
		this.gen10 = gen10;
	}
	public String numGen() {
		Random ran = new Random();
		response ="";
		int length = ran.nextInt(3);
		if(length==0) {
			response = gen6.genAccountNum();
		}else if(length==1) {
			response = gen8.genAccountNum();
		}else if(length==2) {
			response = gen10.genAccountNum();
		}
		return response;
		
	}
	
	

}
