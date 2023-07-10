package uk.lset.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.Status;
import uk.lset.repository.StatusRepository;
import uk.lset.request.StatusRequest;

@Service
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;

	public List<Status> getAllStatuses() {
		return statusRepository.findAll();
	}

	public Optional<Status> getStatus(long statusid) {
		return statusRepository.findById(statusid);
	}

	public Status createStatus(StatusRequest statusRequest) {

		Status status = new Status();
		status.setName(statusRequest.getName());

		return statusRepository.save(status);
	}

	public Status updateStatus(StatusRequest statusRequest) {
		Status status = getStatus(statusRequest.getStatusid()).get();
		
		if (statusRequest.getName() != null) {
			status.setName(statusRequest.getName());
		}
		return status;
	}
}
