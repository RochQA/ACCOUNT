package com.example.demoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses( { AccountNumGenServiceTest.class, AccountNumGenAppTests.class, AccountApplicationTests.class } )

public class SuiteTest {

}

