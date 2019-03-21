package com.example.demo.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.AccountNumGen;
import com.example.demo.service.AccountNumGenService;
import com.example.demo.controller.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AccountNumGenControllerTest {
	
	private static final String testString = "test";
	
	@InjectMocks
	AccountNumGenController uCon;

	@Mock
	AccountNumGenService svc;

//	@Mock
//	AccountNumGen accountNumGen;

	@Before
	public void setup() {
//		uCon.svc;
	}

	@Test
	public void testCreateAccountNumber() {
		Mockito.when(svc.accountNum()).thenReturn(testString);
		assertEquals(testString, uCon.createAccountNumber());
	}
} 
