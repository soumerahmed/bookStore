package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Customer;
import org.polytec.vermeg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> findAllCustomer() {
		return customerService.findAllCustomerService();
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer findCustomerById(@PathVariable int id) {
		return customerService.findCustomerByIdService(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		if (customer.getIdPerson() == 0) {
			customerService.addCustomerService(customer);
		} else {
			customerService.updateCustomerService(customer);
			;
		}

		return "add with success";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id, @RequestBody Customer product) {
		if (customerService.findCustomerByIdService(id) == null) {
			return "  Not exist ";
		} else {

			customerService.updateCustomerService(customerService.findCustomerByIdService(id));
			return " Update with succes";
		}
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomerService(customerService.findCustomerByIdService(id));
		return "deleted with succes";

	}

}
