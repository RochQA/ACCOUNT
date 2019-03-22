package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Account;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class AccountEntityTests {
	
	private Account account1;
	private String MOCK_STRING = "bob";
	private String MOCK_ACC_NUMB = "b12345";
	private Long MOCK_LONG = 1L;
	
	@Before
	public void setUp() {
		account1 = new Account();
	}
	@Test
	public void IDTest() {
		account1.setId(MOCK_LONG);
		assertTrue(MOCK_LONG == (account1.getId()));
	}
	@Test
	public void AccountNameTest() {
		account1.setAccountName(MOCK_STRING);
		assertEquals(MOCK_STRING, account1.getAccountName());
	}
	@Test
	public void AccountNumberTest() {
		account1.setAccountNumber(MOCK_ACC_NUMB);
		assertEquals(MOCK_ACC_NUMB, account1.getAccountNumber());
	}
	@Test
	public void AccountPrizeTest() {
		account1.setPrize(MOCK_STRING);
		assertEquals(MOCK_STRING, account1.getPrize());
	}
	@Test
	public void AccountPassTest() {
		account1.setPassword(MOCK_STRING);
		assertEquals(MOCK_STRING, account1.getPassword());
	}
}
