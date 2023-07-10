package uk.lset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.StatusUpdate;
import uk.lset.repository.StatusUpdateRepository;
import uk.lset.request.StatusUpdateRequest;

@Service
public class StatusUpdateService {
	@Autowired
	private StatusUpdateRepository statusUpdateRepository;

	public List<StatusUpdate> getAllStatusUpdate() {
		return statusUpdateRepository.findAll();
	}

	public StatusUpdate getStatusUpdate(long statusupdateid) {
		return statusUpdateRepository.findById(statusupdateid).get();
	}

	public StatusUpdate createStatusUpdate(StatusUpdateRequest statusUpdateRequest) {
		StatusUpdate statusUpdate = new StatusUpdate();

		statusUpdate.setChangebyuser(statusUpdateRequest.getChangebyuser());
		statusUpdate.setChangedate(statusUpdateRequest.getChangedate());
		statusUpdate.setComment(statusUpdateRequest.getComment());
		statusUpdate.setFromstatus(statusUpdateRequest.getFromstatus());
		statusUpdate.setTostatus(statusUpdateRequest.getTostatus());

		return statusUpdate;
	}

	public StatusUpdate updateStatusUpdate(StatusUpdateRequest statusUpdateRequest) {
		StatusUpdate statusUpdate = getStatusUpdate(statusUpdateRequest.getStatusupdateid());
		if (statusUpdate == null) {
			return null;
		}
		if (statusUpdateRequest.getTostatus() != null) {
			statusUpdate.setTostatus(statusUpdateRequest.getTostatus());
		}
		if (statusUpdateRequest.getFromstatus() != null) {
			statusUpdate.setFromstatus(statusUpdateRequest.getFromstatus());
		}
		if (statusUpdateRequest.getChangebyuser() != null) {
			statusUpdate.setChangebyuser(statusUpdateRequest.getChangebyuser());
		}
		if (statusUpdateRequest.getChangedate() != null) {
			statusUpdate.setChangedate(statusUpdateRequest.getChangedate());
		}
		if (statusUpdateRequest.getComment() != null) {
			statusUpdate.setComment(statusUpdateRequest.getComment());
		}
		if (statusUpdateRequest.getTask() != null) {
			statusUpdate.setTask(statusUpdateRequest.getTask());
		}
		return statusUpdateRepository.save(statusUpdate);

	}

}
