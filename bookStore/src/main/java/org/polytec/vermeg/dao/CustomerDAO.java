package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	Customer findCustomerById(int id);

	List<Customer> findAllCustomer();

	void deleteCustomer(Customer customer);

	void updateCustomer(Customer customer);
}
