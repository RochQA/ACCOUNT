package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	Long id;
	@Column(name="accountname")
	String accountName;
	@Column(name="accountnumber")
	String accountNumber;
	@Column(name="prize")
	String prize;
	@Column(name="password")
	String password;

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

}
