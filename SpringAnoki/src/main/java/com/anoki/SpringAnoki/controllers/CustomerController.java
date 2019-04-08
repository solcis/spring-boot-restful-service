package com.anoki.SpringAnoki.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	
import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.models.Customer;
import com.anoki.SpringAnoki.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
    CustomerService customerService;
	
	@GetMapping
	public Iterable<Customer> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {		
		Optional<Customer> customer = customerService.findById(id);
		if (customer.isPresent()) {
			return new ResponseEntity<>(customer, new HttpHeaders(), HttpStatus.OK);
		}
		//throw new CustomerNotFoundException();
		//return ResponseEntity.badRequest().body("Customer not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	}
	
	@GetMapping("/{id}/shopping_cart")
	public List<Content> cartItems(@PathVariable Long id){
		return customerService.cartItems(id);
	}

	@PostMapping("/{id}/add_funds")
	public Customer addFunds(@PathVariable Long id, @RequestBody Customer customer) {
		return customerService.addFunds(id, customer);
	}
	
	@PostMapping()
	public Customer create(@RequestBody Customer customer) {
		return customerService.create(customer);
	}
	
	@PostMapping("/{id}/shopping_cart/add")
	public List<Content> addItem(@PathVariable Long id, @RequestBody Content content){
		return customerService.addItem(id, content);
	}
	
	@PostMapping("/{id}/shopping_cart/remove")
	public List<Content> removeItem(@PathVariable Long id, @RequestBody Content content){
		return customerService.removeItem(id, content);
	}
	
	@PostMapping("/{id}/shopping_cart/buy")
	public Customer buyItems(@PathVariable Long id){
		return customerService.buyItems(id);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customerService.delete(id);
	}

}
