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

import uk.lset.model.TaskComment;
import uk.lset.request.TaskCommentRequest;
import uk.lset.response.TaskCommentResponse;
import uk.lset.service.TaskCommentService;

@RestController
@CrossOrigin
public class TaskCommentController {
	@Autowired
	private TaskCommentService taskCommentService;

	@GetMapping("/taskcomment/all")
	private List<TaskComment> getAllTaskComments() {
		return taskCommentService.getAllTaskComments();
	}

	@GetMapping(path = "/taskcomment/{priorityid}", consumes = "application/json", produces = "application/json")
	private TaskComment getTask(@PathVariable("taskcommentid") long taskcommentid) {
		return taskCommentService.getTaskComment(taskcommentid);
	}

	@PostMapping(path = "/taskcomment/add", consumes = "application/json", produces = "application/json")
	private TaskComment createStatusUpdate(@RequestBody TaskCommentRequest taskCommentRequest) {
		return taskCommentService.createTaskComment(taskCommentRequest);
	}

	@PutMapping(path = "/taskcomment/update", consumes = "application/json", produces = "application/json")
	private TaskCommentResponse updateTaskComment(@RequestBody TaskCommentRequest taskCommentRequest) {

		TaskComment taskComment = taskCommentService.updateTaskComment(taskCommentRequest);

		TaskCommentResponse taskCommentResponse = new TaskCommentResponse();

		if (taskComment == null) {
			taskCommentResponse.setReponseCode("500");
			taskCommentResponse.setReponseMessage("Could not find task");
		} else {
			//TODO
			taskCommentResponse.setTaskcommentid(taskCommentRequest.getTaskcommentid().toString());
			taskCommentResponse.setReponseMessage("Sucessfully updated task");
		}
		return taskCommentResponse;
	}
}
