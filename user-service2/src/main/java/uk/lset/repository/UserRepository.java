package uk.lset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
