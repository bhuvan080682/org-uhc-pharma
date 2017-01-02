package org.uhc.ws.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uhc.ws.model.Customer;
import org.uhc.ws.service.CustomerService;

@RestController
@RequestMapping(value="/api/pharma")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping(value="/customers",
					produces=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.GET)
	public ResponseEntity<Collection<Customer>> getAllCustomers(){
		Collection<Customer> customers = service.getAllCustomer();
		return new ResponseEntity<Collection<Customer>>(customers,HttpStatus.OK);
	}

	@RequestMapping(value="/customer/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id")Long id){
		Customer customer = service.getCustomerById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer customerCreated = service.saveCustomer(customer);
		return new ResponseEntity<Customer>(customerCreated,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/customer",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.PUT)
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer){
		Customer customerModified = service.modifyCustomer(customer);
		return new ResponseEntity<Customer>(customerModified,HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.DELETE)
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Long id){
		service.removeCustomer(id);
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}
}
