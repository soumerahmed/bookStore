package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.Bill;
import org.polytec.vermeg.model.LineCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateTotalPriceService {

	@Autowired
	BillService billService;
	@Autowired
	LineCommandService lineCommandService;
	@Autowired
	ProductService productService;

	public Double totalPrice(int idOfBill) {
		Double s = 0.0;

		List<LineCommand> l = lineCommandService.getLineCommandByBillIdService(idOfBill);

		for (int i = 0; i < l.size(); i++) {

			s = s + l.get(i).getQt() * l.get(i).getProduct().getIdProduct();

		}
		Bill b = billService.findBillByIdService(idOfBill);
		b.setTotalPrice(s);
		billService.updateBillService(b);
		return s;
	}
}
