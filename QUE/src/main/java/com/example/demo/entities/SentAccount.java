package com.example.demo.entities;

public class SentAccount {

	private Long id;
	private String accountName;
	private String accountNumber;
	private String prize;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SentAccount() {
	}

	public SentAccount(Long id, String accountName, String accountNumber, String prize, String password) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.prize = prize;
		this.password = password;
	}

}
