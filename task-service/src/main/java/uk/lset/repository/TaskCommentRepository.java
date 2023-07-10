package uk.lset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.TaskComment;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {

}