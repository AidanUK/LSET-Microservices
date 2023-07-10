package uk.lset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}