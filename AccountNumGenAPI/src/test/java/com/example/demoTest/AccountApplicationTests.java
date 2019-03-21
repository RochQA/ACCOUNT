package com.example.demoTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.AccountNumGenApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountNumGenApplication.class)
public class AccountApplicationTests {

	@InjectMocks
	AccountNumGenApplication app;
	
	SuiteTest test;

	@Test
	public void contextLoads() {
		assertThat(app).isNotNull();
	}
	@Test
	public void test() {
		
		test=new SuiteTest();
		assertThat(test).isNotNull();
	}


}
