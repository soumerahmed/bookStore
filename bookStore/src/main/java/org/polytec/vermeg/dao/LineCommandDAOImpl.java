package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.LineCommand;
import org.springframework.stereotype.Repository;

@Repository
public class LineCommandDAOImpl extends AbstractHibernateDAO<LineCommand> implements LineCommandDAO {

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
	public int getQuantityOfProductByLineCommand(int id) {
		return findLineCommandById(id).getQt();
	}

	@Override
	public List<LineCommand> findAllLineCommandByBillId(int id) {
		return super.executeQuerySelect("SELECT * FROM linecommand WHERE idBill=" + id);
	}

}
