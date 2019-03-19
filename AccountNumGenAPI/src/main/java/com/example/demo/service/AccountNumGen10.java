package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumGen10 implements AccountNumGen {
	
	@Override
	public String genAccountNum() {


		String generatedAccNum = "";
		Random ran = new Random();
		int letter = ran.nextInt(3);

		if (letter == 0) {
			generatedAccNum += "a";
		} else if (letter == 1) {
			generatedAccNum += "b";
		} else if (letter == 2) {
			generatedAccNum += "c";
		}
		for (int i = 0; i < 10; i++) {
			generatedAccNum += ran.nextInt(10);
		}	
		return generatedAccNum;
	}
	}


