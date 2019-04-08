package com.anoki.SpringAnoki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.anoki.SpringAnoki.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
