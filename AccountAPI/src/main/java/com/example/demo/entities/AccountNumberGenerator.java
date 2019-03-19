package com.example.demo.entities;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumberGenerator {
	
	public String genAccountNum(int length) {


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
		for (int i = 0; i < length; i++) {
			generatedAccNum += ran.nextInt(10);
		}	
		return generatedAccNum;
	}

}
