package org.uhc.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uhc.ws.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
