package uk.lset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.Priority;
import uk.lset.repository.PriorityRepository;
import uk.lset.request.PriorityRequest;

@Service
public class PriorityService {
	@Autowired
	private PriorityRepository priorityRepository;

	public List<Priority> getAllPriority() {
		return priorityRepository.findAll();
	}

	public Priority getPriority(long proprityid) {
		return priorityRepository.findById(proprityid).orElse(null);
	}

	public Priority createPriority(PriorityRequest priorityRequest) {
		Priority priority = new Priority();
		priority.setPrioritydesc(priorityRequest.getPrioritydesc());

		return priorityRepository.save(priority);
	}

	public Priority updatePriority(PriorityRequest priorityRequest) {
		Priority priority = getPriority(priorityRequest.getPriorityid());
		if (priority == null) {
			return null;
		}
		if(priorityRequest.getPrioritydesc() !=null) {
			priority.setPrioritydesc(priorityRequest.getPrioritydesc());
		}
		return priority;
	}

}
