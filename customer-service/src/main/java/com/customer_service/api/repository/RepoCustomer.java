package com.customer_service.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer_service.api.entity.Customer;

@Repository
public interface RepoCustomer extends JpaRepository<Customer, Integer>{

}
