package uk.lset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.TaskComment;
import uk.lset.repository.TaskCommentRepository;
import uk.lset.request.TaskCommentRequest;

@Service
public class TaskCommentService {
	@Autowired
	private TaskCommentRepository taskCommentRepository;

	public List<TaskComment> getAllTaskComments() {
		return taskCommentRepository.findAll();
	}

	public TaskComment getTaskComment(long taskcommentid) {
		return taskCommentRepository.findById(taskcommentid).get();
	}

	public TaskComment createTaskComment(TaskCommentRequest taskCommentRequest) {
		TaskComment taskComment = new TaskComment();
		taskComment.setComment(taskCommentRequest.getComment());
		taskComment.setDate(taskCommentRequest.getDate());
		taskComment.setTaskstatus(taskCommentRequest.getTaskstatus());
		taskComment.setUserid(taskCommentRequest.getUserid());
		taskComment.setTask(taskCommentRequest.getTask());
		
		return taskCommentRepository.save(taskComment);
	}

	public TaskComment updateTaskComment(TaskCommentRequest taskCommentRequest) {
		TaskComment taskComment = getTaskComment(taskCommentRequest.getTaskcommentid());

		if (taskComment == null) {
			return null;
		}

		if (taskCommentRequest.getComment() != null) {
			taskComment.setComment(taskCommentRequest.getComment());
		}
		if (taskCommentRequest.getDate() != null) {
			taskComment.setDate(taskCommentRequest.getDate());
		}
		if (taskCommentRequest.getTask() != null) {
			taskComment.setTask(taskCommentRequest.getTask());
		}
		if (taskCommentRequest.getTaskstatus() != null) {
			taskComment.setTaskstatus(taskCommentRequest.getTaskstatus());
		}
		if (taskCommentRequest.getUserid() != null) {
			taskComment.setUserid(taskCommentRequest.getUserid());
		}

		return taskCommentRepository.save(taskComment);
	}

}
