package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.AccountPrizeGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountPrizeGenServiceTests {
	
	@InjectMocks
	AccountPrizeGenerator prizeGen;
	
	private String MOCK_A_ACC1 = "a1717171";
	private String MOCK_A_ACC2 = "a17183893";	
	private String MOCK_B_ACC1 = "b123456";
	private String MOCK_B_ACC2 = "b12345678";
	private String MOCK_B_ACC3 = "b1234567890";	
	private String MOCK_C_ACC1 = "c123456";
	private String MOCK_C_ACC2 = "c12345678";
	private String MOCK_C_ACC3 = "c1234567890";	
	private String MOCK_FAKE_ACC = "f15151";	
	private String nothing = "Nothing";
	private String minBPrize = "$50";
	private String midBPrize ="$500";
	private String maxBPrize ="$5000";
	private String minCPrize = "$100";
	private String midCPrize = "$750";
	private String maxCPrize ="$10000";
	private String notValid ="Account number not valid!";
	
	@Test
	public void genPrizeTest() {
		assertEquals(prizeGen.genPrize(MOCK_A_ACC1), nothing);
		assertEquals(prizeGen.genPrize(MOCK_A_ACC2), nothing);
		assertEquals(prizeGen.genPrize(MOCK_B_ACC1), minBPrize);
		assertEquals(prizeGen.genPrize(MOCK_B_ACC2), midBPrize);
		assertEquals(prizeGen.genPrize(MOCK_B_ACC3), maxBPrize);
		assertEquals(prizeGen.genPrize(MOCK_C_ACC1), minCPrize);
		assertEquals(prizeGen.genPrize(MOCK_C_ACC2), midCPrize);
		assertEquals(prizeGen.genPrize(MOCK_C_ACC3), maxCPrize);
		assertEquals(prizeGen.genPrize(MOCK_FAKE_ACC), notValid);
	}

}
