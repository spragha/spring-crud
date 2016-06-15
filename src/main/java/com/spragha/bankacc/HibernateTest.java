package com.spragha.bankacc;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spragha.bankacc.model.Customer;
import com.spragha.bankacc.service.BankService;
import com.spragha.bankacc.service.BankServiceImpl;

public class HibernateTest {

	public static void main(String[] args) {
		
		ApplicationContext  applicationContext =new ClassPathXmlApplicationContext("mvc-core-config.xml");
		
		BankService bankService=applicationContext.getBean("bankService", BankService.class);
		Collection<Customer> customer=bankService.findCustomerByLastName("Franklin");
		

	}

}
