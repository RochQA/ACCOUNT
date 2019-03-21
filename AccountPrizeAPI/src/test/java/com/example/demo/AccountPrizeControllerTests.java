package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.AccountPrizeController;
import com.example.demo.service.AccountPrizeGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountPrizeControllerTests {

	@InjectMocks
	AccountPrizeController controller;
	
	@Mock
	AccountPrizeGenerator svc;
	
	private HttpEntity<String> entity = new HttpEntity<>("hi");
	private String MOCK_STRING = "TEST";
	
	@Test
	public void getPrizeTest() {
		Mockito.when(svc.genPrize("hi")).thenReturn(MOCK_STRING);
		assertEquals(controller.getPrize(entity), MOCK_STRING);
	}
}
