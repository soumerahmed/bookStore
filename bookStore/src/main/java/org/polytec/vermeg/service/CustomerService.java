package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.Customer;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {

	@Transactional
	public List<Customer> findAllCustomerService();

	@Transactional
	public Customer findCustomerByIdService(int id);

	@Transactional
	public void addCustomerService(Customer customer);

	@Transactional
	public void updateCustomerService(Customer customer);

	@Transactional
	void deleteCustomerService(Customer customer);
}
