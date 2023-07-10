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

import uk.lset.model.StatusUpdate;
import uk.lset.request.StatusUpdateRequest;
import uk.lset.response.StatusUpdateResponse;
import uk.lset.service.StatusUpdateService;

@RestController
@CrossOrigin
public class StatusUpdateController {
	@Autowired
	private StatusUpdateService statusUpdateService;

	@GetMapping("/statusupdate/all")
	private List<StatusUpdate> getAllStatusUpdate() {
		return statusUpdateService.getAllStatusUpdate();
	}

	@GetMapping(path = "/statusupdate/{statusupdateid}", consumes = "application/json", produces = "application/json")
	private StatusUpdate getTask(@PathVariable("statusupdateid") long statusupdateid) {
		return statusUpdateService.getStatusUpdate(statusupdateid);
	}

	@PostMapping(path = "/statusupdate/add", consumes = "application/json", produces = "application/json")
	private StatusUpdate createStatusUpdate(@RequestBody StatusUpdateRequest statusUpdateRequest) {
		return statusUpdateService.createStatusUpdate(statusUpdateRequest);
	}

	@PutMapping(path = "/statusupdate/update", consumes = "application/json", produces = "application/json")
	private StatusUpdateResponse updateStatusUpdate(@RequestBody StatusUpdateRequest statusUpdateRequest) {

		StatusUpdate statusUpdate = statusUpdateService.updateStatusUpdate(statusUpdateRequest);

		StatusUpdateResponse statusUpdateResponse = new StatusUpdateResponse();

		if (statusUpdate == null) {
			statusUpdateResponse.setReponseCode("500");
			statusUpdateResponse.setReponseMessage("Could not find task");
		} else {
			statusUpdateResponse.setStatusupdateid(statusUpdate.getStatusupdateid().toString());
			statusUpdateResponse.setReponseMessage("Sucessfully updated task");
		}
		return statusUpdateResponse;
	}
}
