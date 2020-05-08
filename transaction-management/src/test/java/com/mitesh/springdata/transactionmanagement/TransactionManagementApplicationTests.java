package com.mitesh.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.transactionmanagement.service.BankAccountService;

@SpringBootTest
class TransactionManagementApplicationTests {

	@Autowired
	BankAccountService bankAccountService;
	
	@Test
	public void transfer() {
		bankAccountService.transfer(500);
	}

}
