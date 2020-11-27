package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAOImpl extends AbstractHibernateDAO<Bill> implements BillDAO {

	public BillDAOImpl() {
		setClazz(Bill.class);
	}

	@Override
	public void addBill(Bill bill) {
		super.save(bill);
	}

	@Override
	public Bill findBillById(int id) {
		return super.findOne(id);
	}

	@Override
	public List<Bill> findAllBill() {
		return super.findAll();
	}

	@Override
	public void deleteBill(Bill bill) {
		super.delete(bill);
	}

	@Override
	public void updateBill(Bill bill) {
		super.update(bill);
	}

}
