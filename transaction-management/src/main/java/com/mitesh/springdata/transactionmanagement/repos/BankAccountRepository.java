package com.mitesh.springdata.transactionmanagement.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount,Integer>{

	void save(Optional<BankAccount> obamaAccount);

}
