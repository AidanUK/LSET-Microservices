package uk.lset.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.lset.model.Status;
import uk.lset.request.StatusRequest;
import uk.lset.response.StatusResponse;
import uk.lset.service.StatusService;

@RestController
@CrossOrigin
public class StatusController {
	@Autowired
	private StatusService statusService;

	@PostMapping(path = "/status/add", consumes = "application/json", produces = "application/json")
	private Status createStatus(@RequestBody StatusRequest statusRequest) {
		return statusService.createStatus(statusRequest);
	}

	@GetMapping(path = "/status/{statusid}", consumes = "application/json", produces = "application/json")
	private Optional<Status> getStatus(@PathVariable("statusid") long statusid) {
		return statusService.getStatus(statusid);
	}

	@GetMapping(path = "/status/all", consumes = "application/json", produces = "application/json")
	private List<Status> getAllStatuses() {
		return statusService.getAllStatus();
	}

	@PutMapping(path = "/status/update", consumes = "application/json", produces = "application/json")
	private StatusResponse updateStatus(@RequestBody StatusRequest statusRequest) {

		Status status = statusService.updateStatus(statusRequest);

		StatusResponse statusResponse = new StatusResponse();

		if (status == null) {
			statusResponse.setReponseCode("500");
			statusResponse.setReponseMessage("Could not find Status");
		} else {
			statusResponse.setStatusid(status.getStatusid());
			statusResponse.setName(status.getName());
			statusResponse.setReponseMessage("Sucessfully updated Status");
		}
		return statusResponse;
	}
}
