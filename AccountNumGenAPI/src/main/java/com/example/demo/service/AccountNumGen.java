package com.example.demo.service;

public interface AccountNumGen {
	
	public String genAccountNum(int length);

	Boolean checkAccountNum(String accNum);

	String accountNum();

}
