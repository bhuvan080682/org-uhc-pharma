package org.uhc.ws.service;

import java.util.Collection;

import org.uhc.ws.model.Customer;

public interface CustomerService {
	
	Collection<Customer> getAllCustomer();
	Customer getCustomerById(Long id);
	Customer saveCustomer(Customer customer);
	Customer modifyCustomer(Customer customer);
	void removeCustomer(Long id);

}
