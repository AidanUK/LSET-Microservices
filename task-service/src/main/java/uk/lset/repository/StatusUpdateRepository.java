package uk.lset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.StatusUpdate;

public interface StatusUpdateRepository extends JpaRepository<StatusUpdate, Long> {

}
