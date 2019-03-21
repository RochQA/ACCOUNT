package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.AccountController;
import com.example.demo.entities.Account;
import com.example.demo.entities.Login;
import com.example.demo.service.AccountServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTests {

	@InjectMocks
	AccountController control;
	
	@Mock
	AccountServiceImp scv;
	
	@Mock
	RestTemplateBuilder restBuild;
	
	@Mock
	RestTemplate rest;
	
	private Account MOCK_ACCOUNT = new Account(); 
	private Account MOCK_ACCOUNT2= new Account();
	private Long MOCK_LONG = 1L;
	private Login MOCK_LOGIN = new Login();
	private String MOCK_STRING = "TEST";
	private HttpEntity<String> MOCK_ENTITY = new HttpEntity<>(MOCK_STRING);
	private ResponseEntity<String> MOCK_RESPONSE = new ResponseEntity<String>(MOCK_STRING, HttpStatus.OK);
	
	@Before
	public void setup() {
		control = new AccountController(scv, restBuild);
		rest = restBuild.build();
	}
	@Test
	public void getAnAccountTest() {
		Mockito.when(scv.getAccount(MOCK_LONG)).thenReturn(MOCK_ACCOUNT);
		assertEquals(MOCK_ACCOUNT, control.getAccount(MOCK_LONG));
	}
	@Test
	public void getAllAccountsTest() {
		List<Account> accounts = new ArrayList<>();
		accounts.add(MOCK_ACCOUNT);
		accounts.add(MOCK_ACCOUNT2);
		Mockito.when(scv.getAllAccounts()).thenReturn(accounts);
		assertEquals(accounts, control.getAccounts());
	}
	@Test
	public void loginTest() {
		Mockito.when(scv.login(MOCK_LOGIN)).thenReturn(MOCK_ACCOUNT);
		assertEquals(MOCK_ACCOUNT, control.login(MOCK_LOGIN));
	}
	@Test
	public void deleteAccountTest() {
		Mockito.when(scv.deleteAccount(MOCK_LONG)).thenReturn(MOCK_STRING);
		assertEquals(MOCK_STRING, control.deleteAccount(MOCK_LONG));
	}
	@Test
	public void updateAccountTest() {
		Mockito.when(scv.updateAccount(MOCK_ACCOUNT)).thenReturn(MOCK_ACCOUNT);
		assertEquals(MOCK_ACCOUNT, control.updateAccount(MOCK_ACCOUNT));
		
	}
}
