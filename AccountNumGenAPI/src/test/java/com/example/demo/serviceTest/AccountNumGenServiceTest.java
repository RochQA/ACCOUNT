package com.example.demo.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.AccountNumber;
import com.example.demo.repository.AccountNumberRepository;
import com.example.demo.service.AccountNumGenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountNumGenServiceTest {

	@InjectMocks
	AccountNumGenService numService;

	@Mock
	AccountNumberRepository numRepo;
	
	private static final String testStringSix = "100000";
	private static final String testStringEight = "10000000";
	private static final String testStringTen = "1000000000";
	@Mock
	Random ran;

//	@Test
//	public void accountNumSix() {
//		Mockito.when(numService.accountNum()).thenReturn(testStringSix);
//		assertEquals(testStringSix, numService.accountNum());
//	}
//	
//	@Test
//	public void accountNumEight() {
//		Mockito.when(numService.accountNum()).thenReturn(testStringEight);
//		assertEquals(testStringEight, numService.accountNum());
//	}
	
	@Test
	public void accountNumTen() {
		Mockito.when(ran.nextInt(3)).thenReturn(2);
		assertEquals(11, numService.accountNum().length());
		assertEquals(11, numService.accountNum().length());
		assertEquals(11, numService.accountNum().length());
		assertEquals(11, numService.accountNum().length());
	}
		

	
	
	@Test
	public void numCheckerTrue() {
		AccountNumber firstAcc = new AccountNumber();
		AccountNumber secondAcc = new AccountNumber();
		AccountNumber thirdAcc = new AccountNumber();

		firstAcc.setAccountNumber("a123456");
		firstAcc.setId((long) 1);
		secondAcc.setAccountNumber("b234567");
		secondAcc.setId((long) 2);
		thirdAcc.setAccountNumber("c345678");
		thirdAcc.setId((long) 3);

		List<AccountNumber> accounts = new ArrayList<AccountNumber>();

		accounts.add(firstAcc);
		accounts.add(secondAcc);
		accounts.add(thirdAcc);

		Mockito.when(numRepo.findAll()).thenReturn(accounts);
		assertEquals(numService.checkAccountNum("b654321"), true);
	}

	@Test
	public void numCheckerFalse() {
		AccountNumber firstAcc = new AccountNumber();
		AccountNumber secondAcc = new AccountNumber();
		AccountNumber thirdAcc = new AccountNumber();

		firstAcc.setAccountNumber("a123456");
		firstAcc.setId((long) 1);
		secondAcc.setAccountNumber("b234567");
		secondAcc.setId((long) 2);
		thirdAcc.setAccountNumber("c345678");
		thirdAcc.setId((long) 3);

		List<AccountNumber> accounts = new ArrayList<AccountNumber>();

		accounts.add(firstAcc);
		accounts.add(secondAcc);
		accounts.add(thirdAcc);

		Mockito.when(numRepo.findAll()).thenReturn(accounts);
		assertEquals(numService.checkAccountNum("a123456"), false);
	}
}