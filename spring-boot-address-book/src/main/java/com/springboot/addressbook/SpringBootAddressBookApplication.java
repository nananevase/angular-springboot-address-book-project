package com.springboot.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class SpringBootAddressBookApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAddressBookApplication.class, args);
	}
}
