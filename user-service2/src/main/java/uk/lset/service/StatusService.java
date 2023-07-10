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

	public List<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	public Status createStatus(StatusRequest statusRequest) {
		Status status = new Status();
		status.setName(statusRequest.getName());
		return statusRepository.save(status);
	}

	public Optional<Status> getStatus(Long statusID) {
		return statusRepository.findById(statusID);
	}

	public Status updateStatus(StatusRequest statusRequest) {
		Status status = getStatus(statusRequest.getStatusid()).orElse(null);
		if (status == null) {
			return null;
		}
		if (statusRequest.getName() != null && !statusRequest.getName().isBlank()) {
			status.setName(statusRequest.getName());
		}
		return statusRepository.save(status);
	}

}
