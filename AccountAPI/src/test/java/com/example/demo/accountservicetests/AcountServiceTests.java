package com.example.demo.accountservicetests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Account;
import com.example.demo.entities.Login;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcountServiceTests {

	@InjectMocks
	AccountServiceImp accountServiceImp;

	@Mock
	AccountRepository accountRepository;
	Login login;

	static Account MOCK_ACCOUNT_1 = new Account();
	static Account MOCK_ACCOUNT_2 = new Account();
	static long MOCK_ACCOUNT_1_ID = 1;
	static long MOCK_ACCOUNT_2_ID = 2;
	static String MOCK_USERNAME = "Jordan";
	static String MOCK_PASSWORD = "Weapon";

	@BeforeClass
	public static void beforeClassSetUp() {
		MOCK_ACCOUNT_1.setId(MOCK_ACCOUNT_1_ID);
		MOCK_ACCOUNT_2.setId(MOCK_ACCOUNT_2_ID);
	}

	@Before
	public void setUp() {
		accountServiceImp = new AccountServiceImp(accountRepository);
		login = new Login();
	}

	@Test
	public void instantiationTest() {

		assertThat(accountServiceImp.getClass()).isNotNull();
	}

	@Test
	public void getAccountTest() {

		List<Account> MOCK_ACCOUNT_LIST = new ArrayList<Account>();
		MOCK_ACCOUNT_LIST.add(MOCK_ACCOUNT_1);
		MOCK_ACCOUNT_LIST.add(MOCK_ACCOUNT_2);
		Mockito.when(accountRepository.findAll()).thenReturn(MOCK_ACCOUNT_LIST);
		assertEquals("getAccount in AccountServiceImp did not return the correct account", MOCK_ACCOUNT_1,
				accountServiceImp.getAccount(MOCK_ACCOUNT_1_ID));
	}

	@Test
	public void createAccountTest() {
		Mockito.when(accountRepository.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals("createAccount in AccountServiceImp did not return the account it was given", MOCK_ACCOUNT_1,
				accountServiceImp.createAccount(MOCK_ACCOUNT_1));
	}

	@Test
	public void deleteByIdAccountTest() {
		assertEquals("deleteByID function in AccountServiceImp did not return 'Account deleted'", "Account deleted",
				accountServiceImp.deleteAccount(MOCK_ACCOUNT_1_ID));
	}

	@Test
	public void updateAccountTest() {
		List<Account> MOCK_ACCOUNT_LIST = new ArrayList<Account>();
		MOCK_ACCOUNT_LIST.add(MOCK_ACCOUNT_1);
		Mockito.when(accountRepository.findAll()).thenReturn(MOCK_ACCOUNT_LIST);
		assertEquals(MOCK_ACCOUNT_1.getId(), accountServiceImp.updateAccount(MOCK_ACCOUNT_1).getId());

	}

	@Test
	public void loginTest() {
		List<Account> MOCK_ACCOUNT_LIST = new ArrayList<Account>();
		MOCK_ACCOUNT_1.setAccountName(MOCK_USERNAME);
		MOCK_ACCOUNT_1.setPassword(MOCK_PASSWORD);
		login.setName(MOCK_USERNAME);
		login.setPassword(MOCK_PASSWORD);
		MOCK_ACCOUNT_LIST.add(MOCK_ACCOUNT_1);
		Mockito.when(accountRepository.findAll()).thenReturn(MOCK_ACCOUNT_LIST);
		
		assertEquals(MOCK_ACCOUNT_1, accountServiceImp.login(login));
	}
	
	@Test
	public void loginFailTest() {
		List<Account> MOCK_ACCOUNT_LIST = new ArrayList<Account>();
		MOCK_ACCOUNT_1.setAccountName(MOCK_USERNAME);
		MOCK_ACCOUNT_1.setPassword(" ");
		login.setName(MOCK_USERNAME);
		login.setPassword(MOCK_PASSWORD);
		MOCK_ACCOUNT_LIST.add(MOCK_ACCOUNT_1);
		Mockito.when(accountRepository.findAll()).thenReturn(MOCK_ACCOUNT_LIST);
		
		assertNotEquals(MOCK_ACCOUNT_1, accountServiceImp.login(login));
		
	}
		
}
