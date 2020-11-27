package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.Bill;
import org.springframework.transaction.annotation.Transactional;

public interface BillService {

	@Transactional
	public List<Bill> findAllBillService();

	@Transactional
	public Bill findBillByIdService(int id);

	@Transactional
	public void addBillService(Bill bill);

	@Transactional
	public void updateBillService(Bill bill);

	@Transactional
	void deleteBillService(Bill bill);

}
