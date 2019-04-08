package com.anoki.SpringAnoki.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anoki.SpringAnoki.exceptions.ContentNotFoundException;
import com.anoki.SpringAnoki.exceptions.CustomerNotFoundException;
import com.anoki.SpringAnoki.exceptions.NotEnoughFoundsException;
import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.models.Customer;
import com.anoki.SpringAnoki.models.ShoppingCart;
import com.anoki.SpringAnoki.models.Transaction;
import com.anoki.SpringAnoki.repositories.ContentRepository;
import com.anoki.SpringAnoki.repositories.CustomerRepository;

@Service
public class CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ContentRepository contentRepo;

	public CustomerService() {
	}
	
	public Iterable<Customer> findAll(){
		return customerRepo.findAll();
	}
	
	public Optional<Customer> findById(Long id) {
		return customerRepo.findById(id);
	}
	
	public List<Content> cartItems(Long id){
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		return c.getSc().getItems();
	}

	@Transactional
	public Customer addFunds(Long id, Customer customer) {
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		c.setWallet(customer.getWallet());
		return c;
	}

	public Customer create(Customer customer) {
		Customer c = new Customer(customer.getUsername(), customer.getPassword());
		return customerRepo.save(c);
	}
	
	@Transactional
	public List<Content> addItem(Long id, Content content){
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		return c.getSc().addItems(content);
	}
	
	@Transactional
	public List<Content> removeItem(Long id, Content content){
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		return c.getSc().removeItem(content);
	}

	@Transactional
	public Customer buyItems(Long id){
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		ShoppingCart cart = c.getSc();
		BigDecimal cartTotal = cart.sumItems();
		if(c.getWallet().compareTo(cartTotal) == -1) {
			throw new NotEnoughFoundsException();
		}
		Transaction t = new Transaction(new Date(), cartTotal, cart.itemsToString());
		c.getTransactions().add(t);
		for (Content content : cart.getItems()) {
			Content cont = contentRepo.findById(content.getItemId()).orElseThrow(ContentNotFoundException::new);
			cont.setCounter(cont.getCounter() + 1);
		}
		c.setWallet(c.getWallet().subtract(cartTotal));
		cart.getItems().clear();
		return c;
	}
	
	@Transactional
	public Customer updateCustomer(Long id, Customer customer){
		String username = customer.getUsername();
		String password = customer.getPassword();
		Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		if(username != null) {
			c.setUsername(username);
		}else if(password != null) {
			c.setPassword(password);
		}
		return c;
	}
	
	@Transactional
	public void delete (Long id) {
		customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
		customerRepo.deleteById(id);
	}

}
