package com.springboot.addressbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAddressBookApplicationTests {

	@Test
	public void contextLoad() {}

}
