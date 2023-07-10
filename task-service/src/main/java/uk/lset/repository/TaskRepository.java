package uk.lset.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {

}
