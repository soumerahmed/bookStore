package org.polytec.vermeg.dao;

import java.util.List;

import org.polytec.vermeg.model.LineCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Repository
public class LineCommandDAOImpl extends AbstractHibernateDAO<LineCommand> implements LineCommandDAO {

	@Autowired
	BillDAO billd;
	@Autowired
	ProductDAO book;

	public LineCommandDAOImpl() {
		setClazz(LineCommand.class);
	}

	@Override
	public void addLineCommand(LineCommand lineCommand) {
		super.save(lineCommand);
	}

	@Override
	public LineCommand findLineCommandById(int id) {
		return super.findOne(id);
	}

	@Override
	public List<LineCommand> findAllLineCommand() {
		return super.findAll();
	}

	@Override
	public void deleteLineCommand(LineCommand lineCommand) {
		super.delete(lineCommand);
	}

	@Override
	public void updateLineCommand(LineCommand lineCommand) {
		super.update(lineCommand);
	}

	@Override
	public int getQuantityOfProductByLineCommand(LineCommand lineCommand) {
		return findLineCommandById(lineCommand.getIdLineCommand()).getQt();
	}

	@Override
	public List<LineCommand> findAllLineCommandByBillId(int id) {

		List<LineCommand> l = super.executeQuerySelect("from LineCommand");
		for (LineCommand c : l) {
			if (c.getBill().getIdBill() != id) {
				l.remove(c);
			}
		}
		return l;
	}

}
