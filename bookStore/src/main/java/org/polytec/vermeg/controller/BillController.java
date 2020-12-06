package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Bill;
import org.polytec.vermeg.service.BillService;
import org.polytec.vermeg.service.CalculateTotalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	BillService billService;
	@Autowired
	CalculateTotalPriceService totalPriceService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Bill> findAllBill() {
		return billService.findAllBillService();
	}

	@RequestMapping(value = "/getBill/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Bill findBillById(@PathVariable int id) {
		return billService.findBillByIdService(id);
	}

	@RequestMapping(value = "/addBill", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBill(@ModelAttribute("bill") Bill bill) {
		if (bill.getIdBill() == 0) {
			billService.addBillService(bill);
			;
		} else {
			billService.updateBillService(bill);
			;
		}

		return "add with success";
	}

	@RequestMapping(value = "/updateBill/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateBill(@PathVariable("id") int id, @RequestBody Bill bill) {
		if (billService.findBillByIdService(id) == null) {
			return " Bill Not exist ";
		} else {

			billService.updateBillService(billService.findBillByIdService(id));
			return " Update Bill with succes";
		}
	}

	@RequestMapping(value = "/deleteBill/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteBill(@PathVariable("id") int id) {
		billService.deleteBillService(billService.findBillByIdService(id));
		return "deleted with succes";

	}

	@RequestMapping(value = "/totalPrice/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getTotalPriceOfBill(@PathVariable("id") int idOfBill) {
		return "Total Price of Bill = " + totalPriceService.totalPrice(idOfBill);
	}

}
