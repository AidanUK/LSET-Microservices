package uk.lset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.lset.model.Priority;
import uk.lset.request.PriorityRequest;
import uk.lset.response.PriorityResponse;
import uk.lset.service.PriorityService;

@RestController
@CrossOrigin
public class PriorityController {
	@Autowired
	private PriorityService priorityService;

	@GetMapping("/priority/all")
	private List<Priority> getAllPriority() {
		return priorityService.getAllPriority();
	}

	@GetMapping(path = "/priority/{priorityid}", consumes = "application/json", produces = "application/json")
	private Priority getPriority(@PathVariable("priorityid") long priorityid) {
		return priorityService.getPriority(priorityid);
	}

	@PostMapping(path = "/priority/add", consumes = "application/json", produces = "application/json")
	private Priority createPriority(@RequestBody PriorityRequest priorityRequest) {
		return priorityService.createPriority(priorityRequest);
	}

	@PutMapping(path = "/priority/update", consumes = "application/json", produces = "application/json")
	private PriorityResponse updatePriority(@RequestBody PriorityRequest priorityRequest) {

		Priority priority = priorityService.updatePriority(priorityRequest);

		PriorityResponse taskResponse = new PriorityResponse();

		if (priority == null) {
			taskResponse.setReponseCode("500");
			taskResponse.setReponseMessage("Could not find task");
		} else {
			taskResponse.setReponseMessage("Sucessfully updated task");
		}
		return taskResponse;
	}
}
