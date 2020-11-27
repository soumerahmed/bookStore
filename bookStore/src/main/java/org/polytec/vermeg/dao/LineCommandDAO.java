package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.LineCommand;

public interface LineCommandDAO {

	void addLineCommand(LineCommand lineCommand);

	LineCommand findLineCommandById(int id);

	List<LineCommand> findAllLineCommand();

	void deleteLineCommand(LineCommand lineCommand);

	void updateLineCommand(LineCommand lineCommand);

	int getQuantityOfProductByLineCommand(int id);

	List<LineCommand> findAllLineCommandByBillId(int id);

}
