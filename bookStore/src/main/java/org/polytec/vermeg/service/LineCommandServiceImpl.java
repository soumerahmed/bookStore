package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.dao.LineCommandDAO;
import org.polytec.vermeg.model.LineCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineCommandServiceImpl implements LineCommandService {

	@Autowired
	LineCommandDAO lineCommandDAO;

	@Override
	public List<LineCommand> findAllLineCommandService() {
		return lineCommandDAO.findAllLineCommand();
	}

	@Override
	public LineCommand findLineCommandByIdService(int id) {
		return lineCommandDAO.findLineCommandById(id);
	}

	@Override
	public void addLineCommandService(LineCommand lineCommand) {
		lineCommandDAO.addLineCommand(lineCommand);
	}

	@Override
	public void updateLineCommandService(LineCommand lineCommand) {
		lineCommandDAO.updateLineCommand(lineCommand);
	}

	@Override
	public void deleteLineCommandService(LineCommand lineCommand) {
		lineCommandDAO.deleteLineCommand(lineCommand);
	}

	@Override
	public int getQuantityOfProductByLineCommandService(LineCommand lineCommand) {
		return lineCommandDAO.getQuantityOfProductByLineCommand(lineCommand);
	}

	@Override
	public List<LineCommand> getLineCommandByBillIdService(int id) {
		return lineCommandDAO.findAllLineCommandByBillId(id);
	}

}
