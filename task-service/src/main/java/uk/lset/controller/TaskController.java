package uk.lset.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.lset.model.Task;
import uk.lset.request.TaskRequest;
import uk.lset.response.TaskResponse;
import uk.lset.service.TaskService;

@RestController
@CrossOrigin
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping("/task/all")
	private List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping(path = "/task/{taskid}", consumes = "application/json", produces = "application/json")
	private TaskResponse getTask(@PathVariable("taskid") long taskid) throws URISyntaxException {

		return taskService.getTask(taskid);
	}

	@PostMapping(path = "/task/add", consumes = "application/json", produces = "application/json")
	private TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
		Task task = taskService.createTask(taskRequest);
		TaskResponse taskResponse = new TaskResponse();
		if (task == null) {
			taskResponse.setReponseCode("500");
			taskResponse.setReponseMessage("Could not find task");
		} else {
			taskResponse.setTaskid(task.getTaskid().toString());
			taskResponse.setReponseMessage("Sucessfully updated task");
		}
		return taskResponse;
	}

	@PutMapping(path = "/task/update", consumes = "application/json", produces = "application/json")
	private TaskResponse updateTask(@RequestBody TaskRequest taskRequest) {

		Task task = taskService.updateTask(taskRequest);

		TaskResponse taskResponse = new TaskResponse();

		if (task == null) {
			taskResponse.setReponseCode("500");
			taskResponse.setReponseMessage("Could not find task");
		} else {
			taskResponse.setTaskid(task.getTaskid().toString());
			taskResponse.setReponseMessage("Sucessfully updated task");
		}
		return taskResponse;
	}
}
