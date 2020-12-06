package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.LineCommand;
import org.polytec.vermeg.service.LineCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lineCommand")
public class LineCommandController {

	@Autowired
	LineCommandService lineCommandService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<LineCommand> findAllLineCommand() {
		return lineCommandService.findAllLineCommandService();
	}

	@RequestMapping(value = "/getLineCommand/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LineCommand findLineCommandById(@PathVariable int id) {
		return lineCommandService.findLineCommandByIdService(id);
	}

	@RequestMapping(value = "/addLineCommand", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addLineCommand(@ModelAttribute("lineCommand") LineCommand lineCommand) {
		if (lineCommand.getIdLineCommand() == 0) {
			lineCommandService.addLineCommandService(lineCommand);
			;
		} else {
			lineCommandService.updateLineCommandService(lineCommand);
			;
		}

		return "add with success";
	}

	@RequestMapping(value = "/updateLineCommand/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateLineCommand(@PathVariable("id") int id, @RequestBody LineCommand lineCommand) {
		if (lineCommandService.findLineCommandByIdService(id) == null) {
			return "  Not exist ";
		} else {

			lineCommandService.updateLineCommandService(lineCommandService.findLineCommandByIdService(id));
			return " Update with succes";
		}
	}

	@RequestMapping(value = "/deleteLineCommand/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteLineCommand(@PathVariable("id") int id) {
		lineCommandService.deleteLineCommandService(lineCommandService.findLineCommandByIdService(id));
		return "deleted with succes";

	}

}
