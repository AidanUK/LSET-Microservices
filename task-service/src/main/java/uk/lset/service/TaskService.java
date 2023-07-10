package uk.lset.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uk.lset.foreignmodel.User;
import uk.lset.model.Task;
import uk.lset.repository.TaskRepository;
import uk.lset.request.TaskRequest;
import uk.lset.response.TaskResponse;
import uk.lset.response.UserResponse;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private PriorityService priorityService;

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public TaskResponse getTask(long taskid) throws URISyntaxException {

		Task task = taskRepository.findById(taskid).get();

		TaskResponse taskResponse = new TaskResponse();

		taskResponse.setDeadlinedate(task.getDeadlinedate());
		taskResponse.setDescription(task.getDescription());
		taskResponse.setPriority(task.getPriority());
		taskResponse.setAssignee(task.getAssignee());

		Long approver = task.getApprover();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		// headers.set("Authorization", token);
		// headers.set("ctoken", company);

		URI userURI = new URI("https://services.123dfdds.co.uk/user/" + approver);
		ResponseEntity<UserResponse> userEntity = restTemplate.exchange(userURI, HttpMethod.GET,
				new HttpEntity<Object>(headers), UserResponse.class);

		if (userEntity != null) {
			UserResponse userRes = userEntity.getBody();
			User user = new User();
			user.setUserid(userRes.getUserid());
			user.setName(userRes.getName());
			taskResponse.setApprover(user);
		}

		return taskResponse;
	}

	public Task createTask(TaskRequest taskRequest) {
		Task task = new Task();
		task.setDescription(taskRequest.getDescription());
		task.setPriority(priorityService.getPriority(taskRequest.getPriority()));
		task.setApprover(taskRequest.getApprover());
		task.setAssignee(taskRequest.getAssignee());
		task.setDeadlinedate(taskRequest.getDeadlinedate());

		return taskRepository.save(task);
	}

	public Task updateTask(TaskRequest taskRequest) {

		//TODO
		Task task = taskRepository.findById(taskRequest.getTaskid()).get();

		if (task == null) {
			return null;
		}

		if (taskRequest.getDescription() != null) {
			task.setDescription(taskRequest.getDescription());
		}

		if (taskRequest.getPriority() != null) {
			task.setPriority(priorityService.getPriority(taskRequest.getPriority()));
		}

		if (taskRequest.getApprover() != null) {
			task.setApprover(taskRequest.getApprover());
		}
		if (taskRequest.getAssignee() != null) {
			task.setAssignee(taskRequest.getAssignee());
		}
		if (taskRequest.getDeadlinedate() != null) {
			task.setDeadlinedate(taskRequest.getDeadlinedate());
		}

		return taskRepository.save(task);
	}

}
