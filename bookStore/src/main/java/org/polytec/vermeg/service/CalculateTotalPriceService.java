package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.BillDAO;
import org.polytec.vermeg.dao.LineCommandDAO;
import org.polytec.vermeg.dao.ProductDAO;
import org.polytec.vermeg.model.Bill;
import org.polytec.vermeg.model.LineCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculateTotalPriceService {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	LineCommandDAO lineCommandDAO;
	@Autowired
	BillDAO billDAO;

	@Transactional
	public Double totalPrice(int idOfBill) {
		Double s = 0.0;
		List<LineCommand> l = lineCommandDAO.findAllLineCommandByBillId(idOfBill);
		for (int i = 0; i < l.size(); i++) {

			s = s + l.get(i).getQt() * productDAO.getPriceByProductId(l.get(i).getProduct().getIdProduct());
		}
		Bill b = billDAO.findBillById(idOfBill);
		b.setTotalPrice(s);
		billDAO.updateBill(b);
		return s;
	}
}
