package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl extends AbstractHibernateDAO<Customer> implements CustomerDAO {

	public CustomerDAOImpl() {
		super.setClazz(Customer.class);
	}

	@Override
	public void addCustomer(Customer customer) {
		super.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		super.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		super.update(customer);
	}

	@Override
	public Customer findCustomerById(int id) {
		return (Customer) super.findOne(id);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return super.findAll();
	}

}