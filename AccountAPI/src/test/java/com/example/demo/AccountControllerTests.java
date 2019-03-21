package com.example.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
	RestTemplate rest;
	
	
	private Account MOCK_ACCOUNT = new Account(); 
	private Account MOCK_ACCOUNT2= new Account();
	private Long MOCK_LONG = 1L;
	private Login MOCK_LOGIN = new Login();
	private String MOCK_STRING = "TEST";
	private HttpEntity<String> MOCK_ENTITY = new HttpEntity<>(MOCK_STRING);
	
	@Before
	public void setup() {
		
	}
	@Test
	public void smokeTest() {
		
	}
}
