package org.uhc.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uhc.ws.model.Customer;
import org.uhc.ws.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	
	@Override
	public Collection<Customer> getAllCustomer() {
		Collection<Customer> customers = repository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = repository.findOne(id);
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if(customer.getId() != null)
			return null;
		Customer customerAdded = repository.save(customer);
		return customerAdded;
	}

	@Override
	public Customer modifyCustomer(Customer customer) {
		if(customer.getId() == null)
			throw new RuntimeException("exception raised");
		Customer customerUpdated = repository.save(customer);
		return customerUpdated;
	}

	@Override
	public void removeCustomer(Long id) {
		repository.delete(id);

	}
	
	

}
