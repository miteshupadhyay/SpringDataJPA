package com.mitesh.springdata.inheritance.HibernateInheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.inheritance.HibernateInheritance.entity.Cheque;
import com.mitesh.springdata.inheritance.HibernateInheritance.entity.CreditCard;
import com.mitesh.springdata.inheritance.HibernateInheritance.repository.PaymentRepository;

@SpringBootTest
class HibernateInheritanceApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void createPayment()
	{
		CreditCard creditCard=new CreditCard();
			creditCard.setId(123);
			creditCard.setCardnumber("123456789");
			creditCard.setAmount(1000);
			paymentRepository.save(creditCard);
	}
	
	@Test
	public void chequePayment()
	{
		Cheque cheque=new Cheque();
		cheque.setId(124);
		cheque.setChequeNumber("123456789");
		cheque.setAmount(1000);
		paymentRepository.save(cheque);
	}
}
