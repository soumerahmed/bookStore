package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Bill;

public interface BillDAO {

	void addBill(Bill bill);

	Bill findBillById(int id);

	List<Bill> findAllBill();

	void deleteBill(Bill bill);

	void updateBill(Bill bill);

}
