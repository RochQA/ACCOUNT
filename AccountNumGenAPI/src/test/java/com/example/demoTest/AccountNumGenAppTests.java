package com.example.demoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.AccountNumGenApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountNumGenAppTests {
	
	@InjectMocks
	AccountNumGenApplication app;
	
	@Test
	public void test() {
		String[] args = new String[] {"random"};
		app.main(args);		
	}

}
