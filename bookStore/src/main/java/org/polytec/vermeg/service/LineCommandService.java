package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.LineCommand;
import org.springframework.transaction.annotation.Transactional;

public interface LineCommandService {

	@Transactional
	public List<LineCommand> findAllLineCommandService();

	@Transactional
	public LineCommand findLineCommandByIdService(int id);

	@Transactional
	public void addLineCommandService(LineCommand lineCommand);

	@Transactional
	public void updateLineCommandService(LineCommand lineCommand);

	@Transactional
	void deleteLineCommandService(LineCommand lineCommand);

	@Transactional
	int getQuantityOfProductByLineCommandService(LineCommand lineCommand);

	@Transactional
	List<LineCommand> getLineCommandByBillIdService(int id);

}
