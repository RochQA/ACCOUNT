package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountPrizeApplicationTests {
	
	@InjectMocks
	AccountPrizeApplication app;
	
	SuiteTest test;

	
	@Before
	public void setup() {
		
	}
	@Test
	public void contextLoads() {
		assertThat(app).isNotNull();
	}
	@Test
	public void test() {
		String[] args = new String[] {"random"};
		app.main(args);
		test=new SuiteTest();
		assertThat(test).isNotNull();
	}

}
