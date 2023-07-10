package uk.lset.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.lset.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByRole(String role);

}
