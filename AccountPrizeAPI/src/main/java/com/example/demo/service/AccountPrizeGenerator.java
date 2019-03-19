package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AccountPrizeGenerator {
	
	public String genPrize(String accNum) {
		
		if(accNum.contains("a")) {
			return "Nothing";
		}else if(accNum.contains("b")) {
			if(accNum.length()==7) {
				return "$50";
			}else if(accNum.length()==9) {
				return "$500";
			}else if(accNum.length()==11) {
				return "$5000";
			}
		}else if(accNum.contains("c")) {
			if(accNum.length()==7) {
				return "$100";
			}else if(accNum.length()==9) {
				return "$750";
			}else if(accNum.length()==11) {
				return "$10000";
			}
		}
		return "Account number not valid!";

		
	}
}


