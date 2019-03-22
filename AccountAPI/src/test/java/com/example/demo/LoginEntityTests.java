package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Login;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class LoginEntityTests {

	public Login login1;
	private String MOCK_STRING = "test";
	@Before
	public void setUp() {
		login1 = new Login();
	}
	@Test
	public void nameTest() {
		login1.setName(MOCK_STRING);
		assertEquals(MOCK_STRING, login1.getName());
	}
	@Test
	public void passwordTest() {
		login1.setPassword(MOCK_STRING);
		assertEquals(MOCK_STRING, login1.getPassword());
	}
}
