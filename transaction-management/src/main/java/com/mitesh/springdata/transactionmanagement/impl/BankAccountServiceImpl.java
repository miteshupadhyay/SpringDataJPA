package com.mitesh.springdata.transactionmanagement.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitesh.springdata.transactionmanagement.entities.BankAccount;
import com.mitesh.springdata.transactionmanagement.repos.BankAccountRepository;
import com.mitesh.springdata.transactionmanagement.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		
		BankAccount obamaAccount = bankAccountRepository.findById(1).orElse(null);
		obamaAccount.setBal(obamaAccount.getBal()-amount);
		bankAccountRepository.save(obamaAccount);
		if(true) {
			throw new RuntimeException();
		}
		BankAccount trumpAccount = bankAccountRepository.findById(2).orElse(null);
		trumpAccount.setBal(trumpAccount.getBal()+amount);
		bankAccountRepository.save(trumpAccount);
	}

}
