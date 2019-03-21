package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses( { AccountPrizeGenServiceTests.class, AccountPrizeControllerTests.class, AccountPrizeApplicationTests.class } )

public class SuiteTest {

}

