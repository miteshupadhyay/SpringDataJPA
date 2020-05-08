package com.mitesh.springdata.inheritance.HibernateInheritance.repository;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.inheritance.HibernateInheritance.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
