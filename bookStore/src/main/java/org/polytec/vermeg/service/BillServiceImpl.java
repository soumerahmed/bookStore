package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.BillDAO;
import org.polytec.vermeg.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillDAO billDAO;

	@Override
	public List<Bill> findAllBillService() {
		return billDAO.findAllBill();
	}

	@Override
	public Bill findBillByIdService(int id) {
		return billDAO.findBillById(id);
	}

	@Override
	public void addBillService(Bill bill) {
		billDAO.addBill(bill);
	}

	@Override
	public void updateBillService(Bill bill) {
		billDAO.updateBill(bill);
	}

	@Override
	public void deleteBillService(Bill bill) {
		billDAO.deleteBill(bill);
	}

}
