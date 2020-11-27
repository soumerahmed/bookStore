package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.dao.CustomerDAO;
import org.polytec.vermeg.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<Customer> findAllCustomerService() {
		return customerDAO.findAllCustomer();
	}

	@Override
	public Customer findCustomerByIdService(int id) {
		return customerDAO.findCustomerById(id);
	}

	@Override
	public void addCustomerService(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	public void updateCustomerService(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerService(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

}
