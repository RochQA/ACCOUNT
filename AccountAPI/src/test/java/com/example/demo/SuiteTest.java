package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses( { AccountEntityTests.class, AccountControllerTests.class, AccountServiceTests.class , AccountApplicationTests.class, LoginEntityTests.class } )

public class SuiteTest {

}

