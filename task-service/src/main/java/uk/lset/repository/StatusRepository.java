package uk.lset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
